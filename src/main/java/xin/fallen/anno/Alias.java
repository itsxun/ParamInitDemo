package xin.fallen.anno;

import java.lang.annotation.*;

/**
 * Author: Fallen
 * Date: 2017/3/23
 * Time: 23:28
 * Usage:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Alias {
    String value() default "";
}