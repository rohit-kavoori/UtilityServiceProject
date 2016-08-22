package com.rsutilities.customerservice.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rsutilities.customerservice.model.Customer;
import com.rsutilities.customerservice.util.HibernateUtil;

/**
 * @author Rohit Kavoori
 * JMS service DAO class to update the service plan id for the given customer id
 * in the database. 
 */
public class MessageServiceDAO {

	/**
	 * Method to update service plan id for the given customer id in the database.
	 * @param c_id
	 * @param serv_id
	 */
	public void updateCustomer(int c_id, int serv_id) {

		Session session = HibernateUtil.getCurrentSession();
		
		try {
			Transaction trans = session.beginTransaction();
			Customer cust = (Customer) session.get(Customer.class, c_id);
			cust.setServiceID(String.valueOf(serv_id));
			session.update(cust);
			trans.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}