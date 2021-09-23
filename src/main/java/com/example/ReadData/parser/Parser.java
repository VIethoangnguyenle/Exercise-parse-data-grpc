package com.example.ReadData.parser;

import java.util.Map;

public interface Parser<T> {
    void parseFrom(Map<Integer, String> map);
    String getParserType();
}
