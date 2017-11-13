package com.jarvis1.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jarvis1.vo.loginVo;
import com.jarvis1.vo.regVo;
@Repository
public class insertDao 
{
	@Autowired
	SessionFactory sessionFactory;
	public void insertDa(regVo rv)
	{
	try
	{	Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(rv);//insert data in db
		tr.commit();
		session.close();
    }
    catch(Exception e1)
    {	
    	System.out.println(e1);
    }
}
	public List search(regVo regvo) {
		List ls=new ArrayList();
		try
		{
		Session session = sessionFactory.openSession();	
		Transaction tr = session.beginTransaction();
		tr.commit();
		Query q=session.createQuery("from regVo");
		q.list();
		ls=q.list();
		System.out.println(ls.size());
		
		session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return ls;
	}
	public List login(loginVo lv) {
		List ls=new ArrayList();
		try
		{
	
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query q=session.createQuery("from loginVo where uname1='"+lv.getUname1()+"' and pwd1='"+lv.getPwd1()+"'");
		//session.save(rv);
		ls.add(q);
		tr.commit();
		session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ls;
		
	}
}
