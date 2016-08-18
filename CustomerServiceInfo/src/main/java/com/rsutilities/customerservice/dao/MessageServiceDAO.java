package com.rsutilities.customerservice.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

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
	 * @param custID
	 * @param serviceID
	 */
	public void updateCustomer(int custID, int serviceID) {

		Session session = HibernateUtil.getSession();
		
		try {
			session.getTransaction().begin();
			Customer cust = (Customer) session.get(Customer.class, custID);
			cust.setServiceID(String.valueOf(serviceID));
			session.update(cust);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}