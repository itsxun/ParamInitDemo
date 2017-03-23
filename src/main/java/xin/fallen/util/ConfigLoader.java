package xin.fallen.util;

import org.apache.commons.beanutils.ConvertUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import xin.fallen.anno.Alias;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by itsxun on 16/12/2.
 */
public class ConfigLoader {

    public static boolean load(File config, Class clazz) {
        Document doc;
        SAXReader reader = new SAXReader();
        if (config == null) {
            return false;
        }
        try {
            doc = reader.read(config);
        } catch (DocumentException e) {
            throw new RuntimeException("配置文件解析异常,原因是：" + e.getMessage());
        }
        HashMap<String, String> configMap = new HashMap<>();
        Iterator it = doc.getRootElement().elementIterator();
        while (it.hasNext()) {
            Element e = (Element) it.next();
            configMap.put(e.getName().trim(), e.getTextTrim());
        }
        if (configMap.size() == 0) {
            return false;
        }
        try {
            for (Field f : clazz.getDeclaredFields()) {
                if (f.isAnnotationPresent(Alias.class)) {
                    Alias alias = f.getAnnotation(Alias.class);
                    if (configMap.containsKey(alias.value())) {
                        System.out.println("给" + alias.value() + "设置值" + configMap.get(alias.value()));
                        f.set(null, ConvertUtils.convert(configMap.get(alias.value()), f.getType()));
                    }
                } else {
                    if (configMap.containsKey(f.getName())) {
                        System.out.println("给" + f.getName() + "设置值" + configMap.get(f.getName()));
                        f.set(null, ConvertUtils.convert(configMap.get(f.getName()), f.getType()));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("转换中出现异常，原因是：" + e.getMessage());
            return false;
        }
        return true;
    }
}