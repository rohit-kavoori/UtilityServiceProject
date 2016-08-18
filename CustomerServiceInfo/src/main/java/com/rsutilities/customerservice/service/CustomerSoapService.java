package com.rsutilities.customerservice.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.rsutilities.customerservice.dao.CustomerSoapServiceDAO;
import com.rsutilities.customerservice.model.ServicePlan;

/**
 * @author Rohit Kavoori
 * Soap service provider class to get all the services from the database.
 */
@WebService
public class CustomerSoapService {

	/**
	 * Method to retrieve service plans from the database.
	 * @return list of service plans.
	 */
	@WebMethod
	public List<ServicePlan> getServicePlan() {
		
		CustomerSoapServiceDAO customerService = new CustomerSoapServiceDAO();
		List<ServicePlan> servicePlans = customerService.getServicePlans();
		return servicePlans;
	}
}
