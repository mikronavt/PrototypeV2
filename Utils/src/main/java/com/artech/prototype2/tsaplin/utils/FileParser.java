package com.artech.prototype2.tsaplin.utils;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 03.12.2014.
 */
public interface FileParser {
    public ArrayList<String> getListOfWordsFromFile(String fileName, String format) throws IOException;
}
