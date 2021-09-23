package com.example.ReadData.reader;

import org.springframework.beans.factory.annotation.Value;

public class DataFileReader extends BaseFileReader{

    private static DataFileReader instance;

    public DataFileReader(String filePath) {
        super(filePath);
        start();
    }

    public static void create(String filePath) {
        if (instance == null) {
            instance = new DataFileReader(filePath);
        }
    }
}
