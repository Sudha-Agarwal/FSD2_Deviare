package runner;

import java.util.Arrays;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import persistence.Department;
import persistence.Employee;
import persistence.Meeting;

public class AppMain {
	

	public static void main(String[] args) {
		
		Configuration configObj = new Configuration();
		
		configObj.configure("hibernate.cfg.xml");
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
		
		SessionFactory sessionFactoryObj = configObj.buildSessionFactory(serviceRegistry);
		Transaction tr =null;
		Session sessionObj =null;
		try {
			sessionObj = sessionFactoryObj.openSession();
			tr = sessionObj.beginTransaction();
			
			Department dept1 = new Department();
			dept1.setName("Finance");			
			
			sessionObj.save(dept1);	
			
			Department dept2 = new Department();
			dept2.setName("IT");
			sessionObj.save(dept2);
			
			
			Employee e1 = new Employee();
			e1.setFirstName("Sudha");
			e1.setLastName("Agarwal");
			e1.setAddress("abc");
			
			e1.setDepartment(dept1);
			
			Employee e2 = new Employee();
			e2.setFirstName("Sudha1");
			e2.setLastName("Agarwal1");
			e2.setAddress("abc1");
			
			e2.setDepartment(dept2);
			
			dept1.setEmpList(Arrays.asList(e1));
			dept2.setEmpList(Arrays.asList(e2));
			
			Meeting meeting1 = new Meeting();
			meeting1.setSubject("AGM");
			meeting1.setMeetingDate(new Date(0));
			
			Meeting meeting2 = new Meeting();
			meeting2.setSubject("sales meeting");
			meeting2.setMeetingDate(new Date(0));
			
			sessionObj.save(meeting2);
			sessionObj.save(meeting1);
			
			
			e1.getMeetings().add(meeting1);
			e1.getMeetings().add(meeting2);
			
			e2.getMeetings().add(meeting1);
			
		
			
			
			sessionObj.save(e1);
			sessionObj.save(e2);
			
			System.out.println("records saved successfully");
			
			tr.commit();
			
		}
		catch(Exception e) {
			if(tr!=null) {
				tr.rollback();
			}
			e.printStackTrace();
			
		}
		finally {
			if(sessionObj != null) {
				sessionObj.close();
			}
		}
		
		
		

	}

}
