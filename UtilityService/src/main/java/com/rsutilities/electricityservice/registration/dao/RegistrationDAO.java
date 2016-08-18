package com.rsutilities.electricityservice.registration.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.rsutilities.electricityservice.registration.model.Customer;


public class RegistrationDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public int insertCustomer(Customer customer) {
		
		int cust_id = 0;
		Session session = sessionFactory.openSession();
		
		try {
			Transaction trans = session.beginTransaction();
			cust_id = (int) session.save(customer);
			trans.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.close();
		return cust_id;
	}
}