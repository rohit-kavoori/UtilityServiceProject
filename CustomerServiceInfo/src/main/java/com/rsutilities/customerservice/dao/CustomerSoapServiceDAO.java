package com.rsutilities.customerservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.rsutilities.customerservice.model.ServicePlan;
import com.rsutilities.customerservice.util.HibernateUtil;

/**
 * @author Rohit Kavoori Soap service DAO class to get all the services from the
 *         database.
 */
public class CustomerSoapServiceDAO {

	/**
	 * Method to retrieve service plans from the database.
	 * 
	 * @return list of service plans.
	 */
	@SuppressWarnings("unchecked")
	public List<ServicePlan> getServicePlans() {
		List<ServicePlan> servicePlanList = new ArrayList<ServicePlan>();
		Session session = HibernateUtil.getSession();

		try {
			servicePlanList = session.createQuery("from ServicePlan").list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		return servicePlanList;
	}
}
