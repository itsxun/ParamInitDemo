package xin.fallen.config;

import xin.fallen.anno.Alias;

/**
 * Author: Fallen
 * Date: 2017/3/23
 * Time: 17:35
 * Usage:
 */
public class StaticConfig {
    @Alias("user_name")
    public static String userName;

    @Alias("user_age")
    public static Integer userAge;

    @Alias("is_happy")
    public static Boolean isHappy;

    @Alias("loveless_java")
    public static Long lovelessJava;

    public static Float salary;
}