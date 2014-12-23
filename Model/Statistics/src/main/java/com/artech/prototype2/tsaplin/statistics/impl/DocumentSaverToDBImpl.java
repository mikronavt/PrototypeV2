package com.artech.prototype2.tsaplin.statistics.impl;

import com.artech.prototype2.saver.dbo.AbstractSUBD;
import com.artech.prototype2.saver.manager.ManagerAPISaver;
import com.artech.prototype2.tsaplin.statistics.DocumentSaverToDB;

/**
 * Created by User on 22.12.2014.
 */
public class DocumentSaverToDBImpl implements DocumentSaverToDB{
    @Override
    public void saveRuDocumentToDB(String fileName, String format, AbstractSUBD db) {
        String label = "document_ru_dao";
        //ManagerAPISaver.getInstance().registry(label, db);
    }

    @Override
    public void saveEnDocumentToDB(String fileName, String format, AbstractSUBD db) {

    }
}
