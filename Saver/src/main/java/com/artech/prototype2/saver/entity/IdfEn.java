package com.artech.prototype2.saver.entity;

import java.io.Serializable;

/**
 * Created by User on 22.12.2014.
 */
public class IdfEn implements Serializable, Entity {
    private Integer enid;
    private Integer docsCount;
    private float idf;

    public IdfEn(){}

    public Integer getEnid() {
        return enid;
    }

    public void setEnid(Integer enid) {
        this.enid = enid;
    }

    public Integer getDocsCount() {
        return docsCount;
    }

    public void setDocsCount(Integer docsCount) {
        this.docsCount = docsCount;
    }

    public float getIdf() {
        return idf;
    }

    public void setIdf(float idf) {
        this.idf = idf;
    }
}
