package com.chao.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ObjectPoolFactory {

    private Map<String, Object> objectPool = new HashMap<>();

    private Object createObject(String clazzName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 根据字符串来获取对应的 Class 对象
        Class<?> clazz = Class.forName(clazzName);
        // 使用 clazz 对应类的默认构造函数创建实例
        return clazz.newInstance();
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> jframeClazz = Class.forName("javax.swing.JFrame");
        Constructor<?> ctor = jframeClazz.getConstructor(String.class);
        Object obj = ctor.newInstance("test");
        System.out.println(obj);
    }
}
