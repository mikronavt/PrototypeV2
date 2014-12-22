package com.artech.prototype2.tsaplin.statistics;

/**
 * Created by User on 22.12.2014.
 */
public interface DocumentSaverToDB {
    public void saveRuDocumentToDB(String fileName, String format);

    public void saveEnDocumentToDB(String fileName, String format);
}
