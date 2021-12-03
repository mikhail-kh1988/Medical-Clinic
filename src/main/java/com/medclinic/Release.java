package com.medclinic;

import com.medclinic.dto.DescribeAnalysisDto;
import com.medclinic.entity.*;
import com.medclinic.repository.impl.AnalysisRepository;
import com.medclinic.repository.impl.AnalysisServiceResultRepository;
import com.medclinic.repository.impl.BillRepository;
import com.medclinic.repository.impl.ClientRepository;
import com.medclinic.service.impl.AnalysisService;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import java.time.LocalDate;
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
                .addAnnotatedClass(Pills.class)
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

        Analysis analysisOfBlood = new Analysis();
        analysisOfBlood.setName("Public analysisOfBlood of blood");
        analysisOfBlood.setDescribe("This analysisOfBlood get know state of organize man.");
        analysisOfBlood.setPrice(150);

        /*em.getTransaction().begin();
        em.merge(analysisOfBlood);
        em.getTransaction().commit();*/

        Analysis analysisOfUrine = new Analysis();
        analysisOfUrine.setName("Analysis of urine");
        analysisOfUrine.setDescribe("Analysis of urine");
        analysisOfUrine.setPrice(100);

        /*em.getTransaction().begin();
        em.merge(analysisOfUrine);
        em.getTransaction().commit();*/

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
        client.setBirthDay(LocalDate.of(1988, 04, 18));

        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();

        Client ivanov = new Client();
        ivanov.setFullName("Petrov Petr");
        ivanov.setAge(25);
        ivanov.setEmail("petrov@mail.ru");
        ivanov.setFirstSymbolName('P');
        ivanov.setPhoneNumber("8971845555");
        ivanov.setActualAddress("Orel");
        ivanov.setLogin("petr");
        ivanov.setFamilyName("Petrov");
        ivanov.setBirthDay(LocalDate.of(1988, 02, 12));

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

        // --------------------------------------------

        Bill oneBill = new Bill();
        oneBill.setClient(client);
        oneBill.setDoctor(doctor);
        oneBill.setPaid(false);
        oneBill.setSum(1000);
        em.getTransaction().begin();
        em.persist(oneBill);
        em.getTransaction().commit();

        Bill twoBill = new Bill();
        twoBill.setClient(client);
        twoBill.setDoctor(doctor);
        twoBill.setPaid(true);
        twoBill.setSum(2000);
        em.getTransaction().begin();
        em.persist(twoBill);
        em.getTransaction().commit();

        Bill threeBill = new Bill();
        threeBill.setClient(client);
        threeBill.setDoctor(doctor);
        threeBill.setPaid(false);
        threeBill.setSum(3000);
        em.getTransaction().begin();
        em.persist(threeBill);
        em.getTransaction().commit();

        Bill fourBill = new Bill();
        fourBill.setClient(client);
        fourBill.setDoctor(doctor);
        fourBill.setPaid(true);
        fourBill.setSum(4000);
        em.getTransaction().begin();
        em.persist(fourBill);
        em.getTransaction().commit();

        AnalysisServiceResult resultOne = new AnalysisServiceResult();
        resultOne.setService(service);
        resultOne.setBill(oneBill);

        AnalysisServiceResult resultTwo = new AnalysisServiceResult();
        resultTwo.setService(service);
        resultTwo.setBill(twoBill);

        AnalysisServiceResult resultThree = new AnalysisServiceResult();
        resultThree.setService(service);
        resultThree.setBill(threeBill);

        AnalysisServiceResult resultFour = new AnalysisServiceResult();
        resultFour.setService(service);
        resultFour.setBill(fourBill);

        // -----------------------------------------

        Doctor doctor1 = em.find(Doctor.class, 1l);

        System.out.println(doctor1.getId()+" "+doctor1.getAge()+" "+doctor1.getFullName());

        AnalysisRepository repository = new AnalysisRepository();
        repository.setEntityManager(em);

        AnalysisServiceResultRepository resultRepository = new AnalysisServiceResultRepository();
        resultRepository.setEntityManager(em);
        resultRepository.save(resultOne);
        resultRepository.save(resultTwo);
        resultRepository.save(resultThree);
        resultRepository.save(resultFour);
        
        repository.save(analysisOfBlood);
        repository.save(analysisOfUrine);

        List<Analysis> list = repository.findByPrice(100);

        for (Analysis analysis: list) {
            System.out.println(+analysis.getId()+"| Analysis name: "+analysis.getName()+" || price:"+analysis.getPrice());
        }

        System.out.println("=====================");

        System.out.println(resultRepository.findByBillID(3));

        System.out.println("========NOT PAID RESULT============");

        List<AnalysisServiceResult> results = resultRepository.findByNotPaidResults();

        for (AnalysisServiceResult result: results) {
            System.out.println(result.getId());
        }

        System.out.println("============= TRY BILLS ====================");

        BillRepository billRepository = new BillRepository();
        billRepository.setEntityClass(Bill.class);
        billRepository.setEntityManager(em);

        List<Bill> billList = billRepository.findByPaid();
        for (Bill bill: billList) {
            System.out.println(bill.getId()+" "+bill.getSum()+" "+bill.getClient().getFullName());
        }


        System.out.println("================ TRY CLIENT REPOSITORY ============");
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.setEntityManager(em);
        clientRepository.save(ivanov);

        List<Client> clients = clientRepository.findByFamily("Petrov");
        for (Client c : clients) {
            System.out.println(c.getId()+" "+c.getFullName()+" "+c.getBirthDay().getYear());
        }

        System.out.println("============== Test analysis service =================");
        DescribeAnalysisDto dto = new DescribeAnalysisDto();
        dto.setDescribe("DSCR FFFFFFF");
        dto.setName("FFFFFF");
        dto.setPrice(999);

        AnalysisService analysisService = new AnalysisService();
        analysisService.setAnalysisRepository(repository);

        long analId = analysisService.createAnalysis(dto).getId();

        System.out.println("Analysis id from service: "+analId);

    }
}
