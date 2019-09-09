package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Student;

public class DeleteStudent {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			
		int studenId= 2;
			
			// MY NEW CODE
			
			// find out the student's id: primary key
			System.out.println("Delete student with  id: " + studenId);
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studenId);
			
			session.delete(myStudent);
			
			
			//No need to save the object as the object is persistent so it all the getters and setters should have the latest value.
			// commit the transaction
			session.getTransaction().commit();
			
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
