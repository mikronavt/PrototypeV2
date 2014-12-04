package com.artech.prototype2.tsaplin.statistics;

import java.io.IOException;

/**
 * Created by User on 03.12.2014.
 */

public interface StatisticWork {

    public void getStatisticFromFile(String fileName, String format) throws IOException;
}
