package com.medclinic;

import com.medclinic.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import javax.persistence.EntityManager;

public class Release {

    public static void main(String[] args){

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .loadProperties("hibernate.properties")
                .build();

        SessionFactory sessionFactory = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Analysis.class)
                .addAnnotatedClass(AnalysisServiceResult.class)
                .addAnnotatedClass(Bill.class)
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Disease.class)
                .addAnnotatedClass(Doctor.class)
                .addAnnotatedClass(Drugs.class)
                .addAnnotatedClass(MedicalCardClient.class)
                .addAnnotatedClass(MedicalService.class)
                .addAnnotatedClass(Therapy.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(WorkFlow.class)
                .addAnnotatedClass(WorkFlowPK.class)
                .addAnnotatedClass(WorkFlowBody.class)
                //.addPackage("com.medclinic.entity")
                .buildMetadata()
                .buildSessionFactory();

        EntityManager em = sessionFactory.createEntityManager();

    }
}
