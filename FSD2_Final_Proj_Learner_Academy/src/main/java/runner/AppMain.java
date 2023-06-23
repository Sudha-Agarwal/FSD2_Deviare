package runner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.java.persistence.CollegeClass;
import com.java.persistence.Student;
import com.java.persistence.Subject;
import com.java.persistence.Teacher;

public class AppMain {
	private static SessionFactory sessionFactory;
	

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
			
			Subject subject1 = new Subject();
			subject1.setSubjectName("Englsih");			
			
			Subject subject2 = new Subject();
			subject1.setSubjectName("Maths");
			
		
			sessionObj.save(subject2);
			sessionObj.save(subject1);
			
			Teacher teacher1 = new Teacher();
			teacher1.setTeacherName("Sudha");
			teacher1.getSubjects().add(subject1);
			teacher1.getSubjects().add(subject2);
			
			Teacher teacher2 = new Teacher();
			teacher2.setTeacherName("Sudha1");
			teacher2.getSubjects().add(subject2);
			
			
			
			Student student1 = new Student();
			student1.setStudentName("Sethunya");
			
			
			CollegeClass class1 = new CollegeClass();
			class1.setClassName("FSD2");
			
			student1.setClasses(class1);
			
			class1.getTeachers().add(teacher1);
			class1.getTeachers().add(teacher2);
			
			class1.getSubjects().add(subject2);
			class1.getSubjects().add(subject1);			
			
			
			sessionObj.save(teacher1);
			sessionObj.save(teacher2);
			sessionObj.save(student1);
			sessionObj.save(class1);
			
			sessionObj.getTransaction().commit();		
						
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
	
	private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.configure("hibernate.cfg.xml");
        	System.out.println("Hibernate Configuration loaded");
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	System.out.println("Hibernate serviceRegistry created");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            ex.printStackTrace();
            throw new ExceptionInInitializerError(ex);
        }
    }
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
	
	

}
