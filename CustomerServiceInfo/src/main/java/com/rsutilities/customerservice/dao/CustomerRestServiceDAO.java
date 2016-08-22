package com.rsutilities.customerservice.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.rsutilities.customerservice.model.Customer;
import com.rsutilities.customerservice.util.HibernateUtil;

/**
 * @author Rohit Kavoori
 * Rest service DAO class to get customer details by id from the database.
 */
public class CustomerRestServiceDAO {

	/**
	 * Method to get customer details for the given id from the database.
	 * @param custID
	 * @return customer
	 */
	public Customer getCustomer(int custID) {
		Customer cust = null;
		Session session = HibernateUtil.getSession();

		try {
			Query query = session.createQuery("from Customer where  id= :id ");
			query.setParameter("id", custID);
			cust = (Customer) query.list().get(0);
		} catch (HibernateException e) {
			e.printStackTrace();
		} 
		return cust;
	}
	

	
}
