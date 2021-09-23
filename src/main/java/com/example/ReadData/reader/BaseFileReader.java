package com.example.ReadData.reader;

import com.example.ReadData.parser.BaseParser;
import com.example.ReadData.parser.Parser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.io.*;
import java.util.*;

@Slf4j
@Component
public abstract class BaseFileReader {

    private static final String delimiter = Character.toString((char) 1);

    private final String filePath;

    BufferedReader bufferedReader;

    public BaseFileReader(String filePath) {
        this.filePath = filePath;
        init();
    }

    public void init(){
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            log.info("create {}", this.getClass().getSimpleName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean readData() {
        try {
            String line;
            if ((line=bufferedReader.readLine())!= null) {
                List<String> array = Arrays.asList(line.split(delimiter));
                Map<Integer, String> data = new HashMap<>();
                array.forEach(item -> {
                    String[] strings = item.split("=", 2);
                    int key = Integer.parseInt(strings[0]);
                    if (strings.length == 2) {
                        if (data.containsKey(key)) {
                            String value = data.get(key);
                            data.put(key, value);
                        }else {
                            data.put(key, strings[1]);
                        }
                    }
                });
                Parser<?> parser = BaseParser.getParser(data.get(35));
                if (parser != null) {
                    parser.parseFrom(data);
                }
                return data.size() > 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void start() {
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                if (bufferedReader != null) {
                    if (readData()) {
                        continue;
                    }
                } else {
                    init();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
