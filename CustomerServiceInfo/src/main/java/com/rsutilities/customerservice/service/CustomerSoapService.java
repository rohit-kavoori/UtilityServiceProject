package com.rsutilities.customerservice.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.rsutilities.customerservice.dao.CustomerServiceDAO;
import com.rsutilities.customerservice.model.ServicePlan;


@WebService
public class CustomerSoapService {

	@WebMethod
	public List<ServicePlan> getServicePlan() {
		List<ServicePlan> servicePlan = CustomerServiceDAO.getServicePlan();
		return servicePlan;
	}
}
