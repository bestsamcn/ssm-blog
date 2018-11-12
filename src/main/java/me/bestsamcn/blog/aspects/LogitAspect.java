package me.bestsamcn.blog.aspects;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.bestsamcn.blog.annotations.ControllerLogit;
import me.bestsamcn.blog.models.Logit;
import me.bestsamcn.blog.models.IpInfoVO;
import me.bestsamcn.blog.services.LogitService;
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
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

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

    @Pointcut("@annotation(me.bestsamcn.blog.annotations.ControllerLogit)")
    public  void controllerAspect() {
    }

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before("controllerAspect()")
    public  void doBefore(JoinPoint joinPoint) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getRemoteAddr();
        try {

            //ip查询
            String result = Tools.sendGet("http://ip.taobao.com/service/getIpInfo.php", "ip="+ip);
            Logit logit = new Logit();
            if(result != null && !result.trim().isEmpty()){
                ObjectMapper objectMapper = new ObjectMapper();
                IpInfoVO ipInfoVO = objectMapper.readValue(result, IpInfoVO.class);
                String code = ipInfoVO.getCode();
                if(code != null && code.equals("0")){
                    Map<String , String> map = ipInfoVO.getData();
                    logit.setAccessIp(ip);
                    logit.setCountry(map.get("country"));
                    logit.setProvince(map.get("region"));
                    logit.setCity(map.get("city"));
                    logit.setDistrict(map.get("area"));
                }
            }
            logit.setId(Tools.getUUID());
            logit.setDescription(getControllerMethodDescription(joinPoint));
            logit.setApiName((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            logit.setType(20);
            logit.setAccessIp(ip);
            logit.setCreateTime(new Timestamp(new Date().getTime()));
            logitService.insert(logit);
        }  catch (Exception e) {
            logger.error("异常信息:{}", e.getMessage());
        }
    }




    /**
     * 获取注解中对方法的描述信息
     * @param joinPoint
     * @return
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
                    description = method.getAnnotation(ControllerLogit.class).description();
                    break;
                }
            }
        }
        return description;
    }
}
