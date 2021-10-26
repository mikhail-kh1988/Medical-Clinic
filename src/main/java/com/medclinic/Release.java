package com.medclinic;

import com.medclinic.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Time;
import java.util.*;

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
                .addAnnotatedClass(MedicalCardBodyPK.class)
                .addAnnotatedClass(MedicalCardBody.class)
                //.addPackage("com.medclinic.entity")
                .buildMetadata()
                .buildSessionFactory();

        EntityManager em = sessionFactory.createEntityManager();

        Doctor doctor = new Doctor();
        doctor.setFullName("Ivanov Ivan Invanovich");
        doctor.setAge(33);
        doctor.setEmail("ivanov@mail.ru");
        doctor.setFirstSymbolName('I');
        doctor.setCertificateNumber("BBBS VO HOSPITAL");
        doctor.setSpecializationName("DOCTOR HIRURG");
        doctor.setLogin("ivan");

        em.getTransaction().begin();
        em.persist(doctor);
        em.getTransaction().commit();

        Client client = new Client();
        client.setFullName("Client Clientsky");
        client.setAge(25);
        client.setEmail("client@mail.ru");
        client.setFirstSymbolName('C');
        client.setPhoneNumber("8971845555");
        client.setActualAddress("Orel");
        client.setLogin("client");
        GregorianCalendar birthday = new GregorianCalendar();
        birthday.setTimeZone(TimeZone.getDefault());
        birthday.set(1988, Calendar.APRIL, 18);
        client.setBirthDay(birthday);

        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();

        MedicalService service = new MedicalService();
        service.setActive(true);
        service.setName("MED OSMOTR");
        service.setDescribe("OSMOTR VSEGO CHELOVEKA");
        service.setExternalCode("W-0001");
        service.setPrice(1500);

        em.getTransaction().begin();
        em.persist(service);
        em.getTransaction().commit();

        Set<MedicalService> medicalServices = new HashSet<>();
        medicalServices.add(service);
        doctor.setMyServices(medicalServices);

        em.getTransaction().begin();
        em.merge(doctor);
        em.getTransaction().commit();

        Doctor doctor1 = em.find(Doctor.class, 1l);

        System.out.println(doctor1.getId()+" "+doctor1.getAge()+" "+doctor1.getFullName());


    }
}
