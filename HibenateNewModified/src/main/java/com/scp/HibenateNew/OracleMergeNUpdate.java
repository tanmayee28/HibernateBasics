package com.scp.HibenateNew;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OracleMergeNUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1=new Employee(1,"Tanmayee",23,50000);//Db tanamyee ram=tanmayee session tanmayee
		Employee e2=new Employee(2,"sushas",24,65000);
		SessionFactory fact=HibernateUtil.getSessionFactory();
		Session se=HibernateUtil.getSession();
		Transaction tr=se.beginTransaction();
		se.save(e1);
		se.save(e2);
		HibernateUtil.flushNCommit(se, tr);
		e1.setEname("Tanamyee2");//ram=tanmayee2;
		
		Session se2=HibernateUtil.getSession();
		Transaction tr2=se2.beginTransaction();
		
		System.out.println("Before get");
		Employee e3=se2.get(Employee.class,1);
		
		System.out.println("After get");
			se2.merge(e1);
		System.out.println(e1);
		
		/*System.out.println("Before Load");
		Employee e3=se2.load(Employee.class,1);
		
		System.out.println("After Load");
		
		e3.setEname("Madhuri");
		
		System.out.println(e1);
		System.out.println(e3);*/
		HibernateUtil.flushNCommit(se2, tr2);
		
		
	}

}
