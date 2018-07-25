package com.scp.HibenateNew;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Hibernate_Transfer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory o_factory=new Configuration().configure().buildSessionFactory();
		SessionFactory my_factory=new Configuration().configure("hibernatemysql.cfg.xml").buildSessionFactory();
		
		Session oraclsession=o_factory.openSession();
		Session mysqlsession=my_factory.openSession();
		
		Transaction o_tr=oraclsession.beginTransaction();
		Transaction my_tr=mysqlsession.beginTransaction();
		
		List<Employee> li=(List<Employee>)mysqlsession.createQuery("from employee_details");
		
		Iterator<Employee> itr=li.iterator();
		
		while(itr.hasNext())
		{
			Employee e=(Employee)itr.next();
			oraclsession.save(e);
		}
		oraclsession.clear();
		mysqlsession.clear();
		 o_tr.commit();
		 my_tr.commit();
		 System.out.println("Hiiii");
	}

}
