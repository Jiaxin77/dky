package hci.dky.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @Author jiaxin
 * @Description 用于登录后才能操作//TODO
 * @Date 4:46 下午 2020/6/18
 * @Param
 * @return
 **/


@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserLoginToken {
    boolean required() default true;
}