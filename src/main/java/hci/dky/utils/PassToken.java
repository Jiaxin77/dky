package hci.dky.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
 * @Author jiaxin
 * @Description 用来跳过验证的passtoken//TODO
 * @Date 4:45 下午 2020/6/18

 **/



@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}