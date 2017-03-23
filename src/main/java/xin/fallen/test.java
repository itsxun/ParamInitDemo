package xin.fallen;

import xin.fallen.config.StaticConfig;
import xin.fallen.util.ConfigLoader;

import java.io.File;

/**
 * Author: Fallen
 * Date: 2017/3/23
 * Time: 17:49
 * Usage:
 */
public class test {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\git\\ParamInitDemo\\src\\main\\resources\\config.xml");
        ConfigLoader.load(file, StaticConfig.class);
        System.out.println("Value：" + StaticConfig.userName + "；Type：" + StaticConfig.userName.getClass().getName());
        System.out.println("Value：" + StaticConfig.userAge + "；Type：" + StaticConfig.userAge.getClass().getName());
        System.out.println("Value：" + StaticConfig.isHappy + "；Type：" + StaticConfig.isHappy.getClass().getName());
        System.out.println("Value：" + StaticConfig.lovelessJava + "；Type：" + StaticConfig.lovelessJava.getClass().getName());
        System.out.println("Value：" + StaticConfig.salary.getClass().getName() + "；Type：" + StaticConfig.salary.getClass().getName().getClass().getName());

    }
}