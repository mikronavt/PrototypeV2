package com.artech.prototype2.saver.bardakov.entity.impl;
// Generated 08.12.2014 1:32:29 by Hibernate Tools 3.6.0

import com.artech.prototype2.saver.titov.entity.EntityDB;
import javax.persistence.Entity;
import javax.persistence.Id;




/**
 * Сущность, которая содержит в себе 
 * связь 2х страниц контента на выбранных языках
 * IndexedWeb generated by hbm2java
 */
@Entity
public class IndexedWeb  implements java.io.Serializable, EntityDB {

     @Id
     private Integer id;
     private String urlT;
     private String urlO;
     private byte[] textRu;
     private byte[] textEn;

    public IndexedWeb() {
    }

    public IndexedWeb(String urlT, String urlO, byte[] textRu, byte[] textEn) {
       this.urlT = urlT;
       this.urlO = urlO;
       this.textRu = textRu;
       this.textEn = textEn;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUrlT() {
        return this.urlT;
    }
    
    public void setUrlT(String urlT) {
        this.urlT = urlT;
    }
    public String getUrlO() {
        return this.urlO;
    }
    
    public void setUrlO(String urlO) {
        this.urlO = urlO;
    }
    public byte[] getTextRu() {
        return this.textRu;
    }
    
    public void setTextRu(byte[] textRu) {
        this.textRu = textRu;
    }
    public byte[] getTextEn() {
        return this.textEn;
    }
    
    public void setTextEn(byte[] textEn) {
        this.textEn = textEn;
    }

}


