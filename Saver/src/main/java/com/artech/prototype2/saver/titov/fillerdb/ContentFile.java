/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.titov.fillerdb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zhenya
 */
// возвращает содержимое файла
public class ContentFile {
    // возвращает список строк в файле
    public static List<String> getStringsFromPath(String path){
        List<String> l = new ArrayList<String>();        
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String s = null;
            try {
                while((s = br.readLine()) != null){
                    l.add(s);
                }
            } catch (IOException ex) {
                Logger.getLogger(ContentFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContentFile.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return l;
    }
    // возвращает содержимое файла
    public static String getContentFileFromPath(String path){
        StringBuilder str = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String s = null;
            try {
                while((s = br.readLine()) != null){
                    str.append(s);
                }
            } catch (IOException ex) {
                Logger.getLogger(ContentFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ContentFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str.toString();
    }
}
