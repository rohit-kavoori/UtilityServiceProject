package com.ekthasol.utilityservice.registration.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ekthasol.utilityservice.registration.model.Customer;
import com.ekthasol.utilityservice.registration.util.HibernateUtil;

public class RegistrationDao {

	public int insertCustomer(Customer customer) {
		int cust_id = 0;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction trans = session.beginTransaction();
			cust_id = (Integer) session.save(customer);
			trans.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.close();
		return cust_id;
	}
}