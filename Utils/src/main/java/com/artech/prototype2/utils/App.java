package com.artech.prototype2.utils;

import com.artech.prototype2.tsaplin.utils.impl.FileParserImpl;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) throws IOException {
        String fileName = "E:\\test.txt";
        FileParserImpl parser = new FileParserImpl();
        ArrayList<String> test = parser.getListOfWordsFromTxt(fileName, "windows-1251");
        for(String t : test)
            System.out.println(t);
        System.out.println("Hello World!");
    }
}
