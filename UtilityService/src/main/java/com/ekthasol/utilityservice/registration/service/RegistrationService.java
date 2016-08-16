package com.ekthasol.utilityservice.registration.service;

import java.util.List;

import com.ekthasol.utilityservice.registration.dao.RegistrationDao;
import com.ekthasol.utilityservice.registration.jms.JmsQueueSender;
import com.ekthasol.utilityservice.registration.model.Customer;
import com.ekthasol.utilityservice.registration.webservice.CustomerSoapService;
import com.ekthasol.utilityservice.registration.webservice.CustomerSoapServiceService;
import com.ekthasol.utilityservice.registration.webservice.ServicePlan;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RegistrationService {

	RegistrationDao registrationDao;
	JmsQueueSender jmsQueueSender;

	public RegistrationService(RegistrationDao registrationDao, JmsQueueSender jmsQueueSender) {
		this.registrationDao = registrationDao;
		this.jmsQueueSender = jmsQueueSender;
	}

	public String insertCustomer(Customer customer) {

		String status = "not registered";
		int cust_id = registrationDao.insertCustomer(customer);
		if(cust_id>0){
			List<ServicePlan> serviceList = getServicePlan();
			status = "registered";
			System.out.println(serviceList.get(0).getServiceId());
			Customer cust = getCustomerDetails(cust_id);
			jmsQueueSender.sendMessage(String.valueOf(cust.getId()) + " " + String.valueOf(serviceList.get(0).getServiceId()));
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