package com.medclinic;

import com.medclinic.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.print.Doc;

public class Release {

    public static void main(String[] args){

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .loadProperties("hibernate.properties")
                .build();

        SessionFactory sessionFactory = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Complaint.class)
                .addAnnotatedClass(ComplaintTherapyUser.class)
                .addAnnotatedClass(ComplaintTherapyUserId.class)
                //.addPackage("com.medclinic.entity")
                .buildMetadata()
                .buildSessionFactory();

        EntityManager em = sessionFactory.createEntityManager();

    }
}
