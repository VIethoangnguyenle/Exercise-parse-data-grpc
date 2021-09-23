package com.example.ReadData.parser;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseParser<T> implements Parser<T> {

    private static final Map<String, BaseParser<?>> parsers = new HashMap<>();

    public BaseParser() {
        parsers.put(getParserType(), this);
    }

    protected int getInt(Map<Integer, String> data, int tag) {
        return Integer.parseInt(data.getOrDefault(tag, "0"));
    }


    public Double getDecimal(Map<Integer, String> data, int tag) {
        return Double.parseDouble(data.getOrDefault(tag, "0"));
    }
    protected String getDate(Map<Integer, String> data, int tag) {
        return data.getOrDefault(tag, "");
    }

    protected String getString(Map<Integer, String> data, int tag) {
        return data.getOrDefault(tag, "");
    }

    public static BaseParser<?> getParser(String type) {
        if (type == null) {
            return null;
        }
        return parsers.get(type);
    }

    abstract void sendMessage(T message);
}
