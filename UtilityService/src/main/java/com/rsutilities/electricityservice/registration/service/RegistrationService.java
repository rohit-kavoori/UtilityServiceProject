package com.rsutilities.electricityservice.registration.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.rsutilities.electricityservice.registration.dao.RegistrationDAO;
import com.rsutilities.electricityservice.registration.jms.JmsQueueSender;
import com.rsutilities.electricityservice.registration.model.Customer;
import com.rsutilities.electricityservice.registration.webservice.CustomerSoapService;
import com.rsutilities.electricityservice.registration.webservice.CustomerSoapServiceService;
import com.rsutilities.electricityservice.registration.webservice.ServicePlan;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RegistrationService {

	final static Logger logger = Logger.getLogger(RegistrationService.class);
	RegistrationDAO registrationDAO;
	JmsQueueSender jmsQueueSender;

	public RegistrationService(RegistrationDAO registrationDAO, JmsQueueSender jmsQueueSender) {
		this.registrationDAO = registrationDAO;
		this.jmsQueueSender = jmsQueueSender;
	}

	public String saveCustomer(Customer customer) {

		String status = "notRegistered";
		int cust_id = registrationDAO.saveCustomer(customer);
		if(cust_id>0){
			List<ServicePlan> serviceList = getServicePlan();
			System.out.println(serviceList.get(0).getServiceId());
			Customer cust = getCustomerDetails(cust_id);
			jmsQueueSender.sendMessage(String.valueOf(cust.getId()) + " " + String.valueOf(serviceList.get(0).getServiceId()));
			status = "Service Plan ID: " + serviceList.get(0).getServiceId() + " and Service Plan:" + serviceList.get(0).getServicaplan();
			logger.info("Customer is registered");
		}
		return status;
	}

	public List<ServicePlan> getServicePlan() {

		CustomerSoapServiceService customerSoapService = new CustomerSoapServiceService();

		CustomerSoapService service = customerSoapService.getCustomerSoapServicePort();

		List<ServicePlan> serviceList = service.getServicePlan();

		return serviceList;
	}

	public Customer getCustomerDetails(Integer id) {

		Customer cust = null;
		try {
			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/CustomerServiceInfo/RestWS/customer/" + id);
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			cust = response.getEntity(Customer.class);
			System.out.println(cust.getFirstName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cust;
	}
}