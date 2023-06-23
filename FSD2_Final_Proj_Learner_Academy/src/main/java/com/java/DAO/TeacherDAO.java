package com.java.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.java.persistence.Teacher;

import runner.AppMain;

public class TeacherDAO {
	
	SessionFactory sessionFactoryObj = AppMain.getSessionFactory();
	Session sessionObj;

	
	@SuppressWarnings("finally")
	public int addTeacher(Teacher teacher) {
		try {
			sessionObj = sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			sessionObj.saveOrUpdate(teacher);
			sessionObj.getTransaction().commit();
		}
		catch(Exception ex) {
			if(null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
				return 0;
			}
		}
		finally {
			sessionObj.close();
			return 1;
		}
	}

	
	public List<Teacher> getTeacher() {
		 Session session = null;
		    try {
		        session = sessionFactoryObj.openSession();
		        Query query = session.createQuery("FROM Teacher");
		        List teachers = query.list();
		        return teachers;
		    } catch (HibernateException ex) {
		        // Handle exceptions
		        ex.printStackTrace();
		    } finally {
		        if (session != null) {
		            session.close();
		        }
		    }
		    return null;
	}

	
	public Teacher getTeacher(int teacherId) {
		Teacher list = null;
		try {
		sessionObj = sessionFactoryObj.openSession();
		sessionObj.getTransaction().begin();	
		Query q=sessionObj.createQuery("from Teacher where teacher_id=:i");  
		q.setParameter("i",teacherId);  
		list=(Teacher) q.uniqueResult();
		}
		catch(Exception ex) {
			if(null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();				
			}				
		}
		finally {
			sessionObj.close();	
		}
		return list;
		//return sessionObj.createQuery("select *  FROM teacher WHERE teacher_id = "+teacherId).executeUpdate();
		//Teacher teacher =  (Teacher) sessionObj.get(Teacher.class, teacherId);
		//sessionObj.getTransaction().commit();
		//return teacher;
		
		/*
		 * sessionObj = sessionFactoryObj.getCurrentSession();
		 * sessionObj.getTransaction().begin(); //sessionFactoryObj.getCurrentSession().
		 * createQuery("select*  FROM department WHERE id = "+id).executeUpdate();
		 * Meeting meeting = (Meeting) sessionObj.get(Meeting.class, id);
		 * sessionObj.getTransaction().commit(); return meeting;
		 */
				
	}

	
	public void deleteTeacher(int id) {
		Session session = null;
	    Transaction transaction = null;
	    try {
	        session = sessionFactoryObj.openSession();
	        transaction = session.beginTransaction();

	        Teacher teacher = (Teacher) session.get(Teacher.class, id);
	        if (teacher != null) {
	            session.delete(teacher);
	            transaction.commit();
	            System.out.println("Teacher with ID " + id + " deleted successfully.");
	        } else {
	            System.out.println("Teacher with ID " + id + " not found.");
	        }
	    } catch (HibernateException ex) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        // Handle exceptions
	        ex.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
		
	}

	
	
	

}
