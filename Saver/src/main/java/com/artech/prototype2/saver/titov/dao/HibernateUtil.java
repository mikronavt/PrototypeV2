/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artech.prototype2.saver.titov.dao;

import com.artech.prototype2.saver.titov.fillerdb.ContentFile;
import java.io.File;
import java.util.List;
import javax.imageio.spi.ServiceRegistry;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Zhenya
 */
/**
 * 
 * настройка Hibernate
 */
public class HibernateUtil {
    
    private static SessionFactory sessionFactory;
    /**
     * переменные для настройки соединения
     */
    protected static String user, password, port;
    public static String path = "C:\\Users\\CANDY\\Dropbox\\PrototypeV2\\Saver\\src\\main\\resources";
    
    private static String getParameterFromName(String name, List<String> list){
        for(String s : list){
            int index = s.indexOf(name);
            if(index >= 0){
                int begin = index + name.length() + 1;
                String value = s.substring(begin, s.length());
                return value;
            }
        }
        return "";
    }
    
    /**
     * находит параметры которые нужны для подключения к БД mysql
     * @param p - строковое имя параметра
     */
    private static void findParamsMysql(String p){
        String pathLocal = p + File.separator + "parametersmysql.properties";        
        List<String> list = ContentFile.getStringsFromPath(pathLocal);
        user = getParameterFromName("user",list);
        password = getParameterFromName("password",list);
        port = getParameterFromName("port",list);
    }        
    
    /**
     * создает необходимые настройки Hibernate
     */
    public static void createSessionFactory(){
        try {            
//            String path = new File().getAbsolutePath() + File.separator + "src" + File.separator + "main" + File.separator + "resources";                
            findParamsMysql(path);
            Configuration c = HibernateUtil.configureHibernate(user, password, port);            
            sessionFactory = c.buildSessionFactory();//   new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    /**
     * создается объект класса Configuration     
     * @param user пользователь 
     * @param password пароль
     * @param port порт
     * @return Configuration
     */
    private static Configuration configureHibernate(String user, String password, String port){
        Configuration conf = new Configuration().setProperty("hibernate.connection.url", "jdbc:mysql://localhost:" + port + "/prototype?zeroDateTimeBehavior=convertToNull")
                .setProperty("hibernate.connection.username", user).setProperty("hibernate.connection.password", password);//.addPackage("Entities").addAnnotatedClass(DictEn.class);                
        return conf;
    }
    
    /**
     * Возвращает sessionFactory
     * @return sessionFactory
     */
    public static SessionFactory getSessionFactory() {
        if(sessionFactory==null)
            createSessionFactory();
        return sessionFactory;
    }
}
