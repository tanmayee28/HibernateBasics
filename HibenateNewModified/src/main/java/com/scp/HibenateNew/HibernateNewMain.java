package com.scp.HibenateNew;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateNewMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ComicBook c1=new ComicBook(10,400,"Mr Frank","Marval");
			TechnicalBook b1=new TechnicalBook(3, 150,"Mr Sachdev","Java");
			ComicBook b2=new ComicBook(1,100,"joshi","Champak");
			SessionFactory factory=new Configuration().configure("hibernatemysql.cfg.xml").buildSessionFactory();
			Session session=factory.openSession();
			Transaction tr=session.beginTransaction();
			session.save(c1);
			session.save(b1);
			session.save(b2);
			session.flush();
			tr.commit();
			//System.out.println("HIII");
			
	}

}
