package me.bestsamcn.blog.annotations;

import java.lang.annotation.*;

/**
 * @Author: Sam
 * @Date: 2018/11/12 21:49
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public  @interface ControllerLog {
    //参数
    String description()  default "";
}
