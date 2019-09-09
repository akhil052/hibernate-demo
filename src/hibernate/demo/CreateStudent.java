package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.entity.Student;

public class CreateStudent {
	
	public static void main(String args[]) {
		
		//create the Sessionfactory
		
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create the Session object
		
		Session sessionobject = factory.getCurrentSession();
		
		try {
			//use this session object to save java object.
			System.out.println("this session to save the java object");
			
			//create a student object
			
			Student stu = new Student("Ishita", "Kalra", "ak2325@njit.edu");
			
			//start a transaction
			
			sessionobject.beginTransaction();
			
			//save the student object
			
			sessionobject.save(stu);
						
			//commit transaction
			
			sessionobject.getTransaction().commit();
			
			
		
		
	}finally {
		factory.close();
	}

}
	
}
