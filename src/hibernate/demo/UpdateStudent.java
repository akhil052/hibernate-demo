package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			
		int studenId= 1;
			
			// MY NEW CODE
			
			// find out the student's id: primary key
			System.out.println("update student with  id: " + studenId);
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, studenId);
			
			myStudent.setFirstName("Khasmanukhani");
			
			System.out.println("Get complete: " + myStudent);
			//No need to save the object as the object is persistent so it all the getters and setters should have the latest value.
			// commit the transaction
			session.getTransaction().commit();
			
			
			//new code to update mails of all the students
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Student set email='laggaye@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
