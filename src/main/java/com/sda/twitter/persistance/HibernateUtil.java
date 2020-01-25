package com.sda.twitter.persistance;

//import org.hibernate.SessionFactory;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.cfg.Configuration;
//
//public class HibernateUtil {
//    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();
//
//    private static SessionFactory buildSessionFactory() {
////        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
////                .configure("hibernate.cfg.xml").build();
////        Metadata metadata = new MetadataSources(serviceRegistry)
////                .getMetadataBuilder().build();
////        return metadata.getSessionFactoryBuilder().build();
//        try {
////            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
////                    .configure("hibernate.cfg.xml").build();
////            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
////            return metadata.getSessionFactoryBuilder().build();
//            return new Configuration()
//                    .configure()
//                    .buildSessionFactory();
//        }catch (Throwable ex) {
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return SESSION_FACTORY;
//    }
//
//    public static void shutDown() {
//        getSessionFactory().close();
//    }
//
//}

import com.sda.twitter.utils.EnvironmentVariableUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static final String HIBERNATE_CONNECTION_PASSWORD = "hibernate.connection.password";
    private static final String HIBERNATE_CONNECTION_USERNAME = "hibernate.connection.username";
    private static final String HIBERNATE_CONNECTION_URL = "hibernate.connection.url";
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
//                    .configure("hibernate.cfg.xml").build();
//            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
//            return metadata.getSessionFactoryBuilder().build();
            //                    .build();
            return new Configuration()
                    .setProperty(HIBERNATE_CONNECTION_URL, EnvironmentVariableUtil.getVariable(HIBERNATE_CONNECTION_URL))
                    .setProperty(HIBERNATE_CONNECTION_PASSWORD, EnvironmentVariableUtil.getVariable(HIBERNATE_CONNECTION_PASSWORD))
                    .setProperty(HIBERNATE_CONNECTION_USERNAME, EnvironmentVariableUtil.getVariable(HIBERNATE_CONNECTION_USERNAME))
                    .configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutDown() {
        getSessionFactory().close();
    }

}
