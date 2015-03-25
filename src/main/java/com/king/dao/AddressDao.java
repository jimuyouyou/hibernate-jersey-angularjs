package com.king.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.king.entity.Address;
import com.king.test.HibernateTest;

public class AddressDao {
	public void getAddress() {
		Session session = HibernateTest.getSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "from Address";
		Query qry = session.createQuery(hql);
		List<Address> list = qry.list();
		System.out.println(list.size());
		tx.commit();
		session.close();	
	}
}
