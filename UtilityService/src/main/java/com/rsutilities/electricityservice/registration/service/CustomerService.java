package com.rsutilities.electricityservice.registration.service;

import java.util.List;

import com.rsutilities.electricityservice.registration.dao.RegistrationDAO;
import com.rsutilities.electricityservice.registration.jms.JmsQueueSender;
import com.rsutilities.electricityservice.registration.model.Customer;
import com.rsutilities.electricityservice.registration.webservice.CustomerSoapService;
import com.rsutilities.electricityservice.registration.webservice.CustomerSoapServiceService;
import com.rsutilities.electricityservice.registration.webservice.ServicePlan;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CustomerService {

	RegistrationDAO registrationDAO;
	JmsQueueSender jmsQueueSender;

	public CustomerService(RegistrationDAO registrationDAO, JmsQueueSender jmsQueueSender) {
		this.registrationDAO = registrationDAO;
		this.jmsQueueSender = jmsQueueSender;
	}

	public String[] saveCustomer(Customer customer) {

		String str = null;
		String[] result = null;
		int cust_id = registrationDAO.insertCustomer(customer);
		if (cust_id > 0) {
			List<ServicePlan> serviceList = getServicePlans();
			jmsQueueSender.sendMessage(
					String.valueOf(cust_id) + " " + String.valueOf(serviceList.get(0).getServiceId()));
			Customer cust = getCustomerDetails(cust_id);
			str =  cust.toString() + "," + serviceList.get(0).getServiceId() + "," + serviceList.get(0).getServiceplan();
			result = str.split(",");
		}
		return result;
	}

	public List<ServicePlan> getServicePlans() {

		CustomerSoapServiceService customerSoapService = new CustomerSoapServiceService();

		CustomerSoapService service = customerSoapService.getCustomerSoapServicePort();

		List<ServicePlan> serviceList = service.getServicePlan();

		return serviceList;
	}

	/**
	 * @param id
	 * @return Rest call to get the customer details from the
	 *         CustomerServiceInfo application
	 */
	public Customer getCustomerDetails(int id) {

		Customer cust = null;
		try {
			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/CustomerServiceInfo/RestWS/customer/" + id);
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			cust = response.getEntity(Customer.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cust;
	}

}