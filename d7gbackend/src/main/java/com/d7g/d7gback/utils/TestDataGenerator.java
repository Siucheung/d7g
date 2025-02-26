package com.d7g.d7gback.utils;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class TestDataGenerator {
    public String detectType(Object param) {
        if (param instanceof String)
            return "String";
        if (param instanceof Integer)
            return "Integer";
        if (param instanceof Double)
            return "Double";
        if (param instanceof Boolean)
            return "Boolean";
        if (param instanceof Long)
            return "Long";
        if (param instanceof Float)
            return "Float";
        if (param instanceof Character)
            return "Character";
        if (param instanceof Byte)
            return "Byte";
        if (param instanceof Short)
            return "Short";
        if (param instanceof Object[])
            return "Object[]";
        if (param instanceof List)
            return "List";
        if (param instanceof Map)
            return "Map";
        return "Unknown";
    }

    // 测试数据生成方法
    public Object generateTestData(Object param) {
        String type = detectType(param);
        switch (type) {
            case "String":
                return generateString();
            case "Integer":
                return generateInteger();
            case "Double":
                return generateDouble();
            case "Boolean":
                return generateBoolean();
            case "Long":
                return generateLong();
            case "Float":
                return generateFloat();
            case "Character":
                return generateCharacter();
            case "Byte":
                return generateByte();
            case "Short":
                return generateShort();
            case "Object[]":
                return generateObjectArray();
            case "List":
                return generateList();
            case "Map":
                return generateMap();
            default:
                return "Unsupported Type";
        }
    }

    private String generateString() {
        return "TestString_" + System.currentTimeMillis();
    }

    private Integer generateInteger() {
        return (int) (Math.random() * 1000);
    }

    private Double generateDouble() {
        return Math.random() * 1000.0;
    }

    private Boolean generateBoolean() {
        return Math.random() > 0.5;
    }

    private Long generateLong() {
        return System.currentTimeMillis();
    }

    private Float generateFloat() {
        return (float) (Math.random() * 1000.0);
    }

    private Character generateCharacter() {
        return 'A';
    }

    private Byte generateByte() {
        return (byte) (Math.random() * 100);
    }

    private Short generateShort() {
        return (short) (Math.random() * 1000);
    }

    private Object[] generateObjectArray() {
        return new Object[] { generateString(), generateInteger(), generateDouble() };
    }

    private List<Object> generateList() {
        List<Object> list = new java.util.ArrayList<>();
        list.add(generateString());
        list.add(generateInteger());
        return list;
    }

    private Map<String, Object> generateMap() {
        Map<String, Object> map = new java.util.HashMap<>();
        map.put("key1", generateString());
        map.put("key2", generateInteger());
        return map;
    }
}
