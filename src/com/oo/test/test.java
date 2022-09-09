package com.oo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class test {
    public static void main(String[] args) {
        Properties properties = new Properties();
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("com/oo/test/db.properties");
        try {
            properties.load(resourceAsStream);
            String driver = properties.getProperty("driver");
            System.out.println(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
