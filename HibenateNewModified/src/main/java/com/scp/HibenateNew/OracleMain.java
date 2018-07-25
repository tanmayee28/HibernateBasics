package com.scp.HibenateNew;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OracleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session se=sf.openSession();
		Transaction tr=se.beginTransaction();
		System.out.println("Successfull...");
		//public Employee(int eid, String ename, int age, double esalary)
		Employee e=new Employee(1,"Tanu",23,50000);
		Employee e1=new Employee(2,"Mona",24,35000);
		
		se.save(e);
		se.save(e1);
		
		se.flush();
		tr.commit();
		
		System.out.println("Hiiii");
	}

}
