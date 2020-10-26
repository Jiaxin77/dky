package hci.artedu.utils;

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


@Target({ElementType.METHOD, ElementType.TYPE})//@Target说明了Annotation所修饰的对象范围：Annotation可被用于 packages、types（类、接口、枚举、Annotation类型）、类型成员（方法、构造方法、成员变量、枚举值）、方法参数和本地变量（如循环变量、catch参数）。
@Retention(RetentionPolicy.RUNTIME)//注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
public @interface UserLoginToken {
    boolean required() default true;
}