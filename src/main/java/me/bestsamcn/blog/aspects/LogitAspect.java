package me.bestsamcn.blog.aspects;

import me.bestsamcn.blog.annotations.ControllerLog;
import me.bestsamcn.blog.models.Admin;
import me.bestsamcn.blog.models.Logit;
import me.bestsamcn.blog.services.LogitService;
import me.bestsamcn.blog.utils.Session;
import me.bestsamcn.blog.utils.Tools;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author: Sam
 * @Date: 2018/11/12 22:10
 */

@Aspect
@Component
public class LogitAspect {

    @Autowired
    private LogitService logitService;

    private  static  final Logger logger = LoggerFactory.getLogger(LogitAspect.class);

    //Controller层切点
    @Pointcut("@annotation(me.bestsamcn.blog.annotations.ControllerLog)")
    public  void controllerAspect() {
    }

    /**
     * 前置通知
     *
     * @param joinPoint 切点
     */
    @Before("controllerAspect()")
    public  void doBefore(JoinPoint joinPoint) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getRemoteAddr();
        try {
            //*========控制台输出=========*//
            System.out.println("=====前置通知开始=====");
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));
            System.out.println("请求IP:" + ip);
            //*========数据库日志=========*//
            Logit logit = new Logit();
            logit.setId(Tools.getUUID());
            logit.setDescription(getControllerMethodDescription(joinPoint));
            logit.setApiName((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            logit.setType(20);
            logit.setAccessIp(ip);
            logit.setCreateTime(new Timestamp(new Date().getTime()));

            //保存数据库
            logitService.insert(logit);
            System.out.println("=====前置通知结束=====");
        }  catch (Exception e) {
            //记录本地异常日志
            logger.error("==前置通知异常==");
            logger.error("异常信息:{}", e.getMessage());
        }
    }




    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(ControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }
}
