package com.scp.HibenateNew;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	static SessionFactory sf=null;
	
	
	public static synchronized  SessionFactory getSessionFactory()
	{
		if(sf==null)
		{
			sf=new Configuration().configure().buildSessionFactory();
		}
		return sf;
	}
	public static synchronized  Session getSession()
	{
		Session se=null;
		if(se==null)
		{
			se=sf.openSession();
		}
		return se;
	}
	public static void flushNCommit(Session se,Transaction tr)
	{
		if(se!=null)
		{
			se.flush();
		}
		if(tr!=null)
		{
			tr.commit();
		}
	}
	
}
