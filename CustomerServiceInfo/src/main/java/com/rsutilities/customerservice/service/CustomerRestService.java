package com.rsutilities.customerservice.service;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.rsutilities.customerservice.dao.CustomerRestServiceDAO;
import com.rsutilities.customerservice.model.Customer;

/**
 * @author Rohit Kavoori
 * Rest service provider class to get customer details by id from the database.
 */
@Path("/customer")
public class CustomerRestService {

	
	final static Logger logger = Logger.getLogger(CustomerRestServiceDAO.class);
	
	/**
	 * Method to get customer details for the given id from the database.
	 * @param custID
	 * @return customer
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@HeaderParam(value = "content-type = application/octet-stream")
	@Path("/{param}")
	public Customer getCustomer(@PathParam("param") int custID) {
		
		CustomerRestServiceDAO customerService = new CustomerRestServiceDAO();
		Customer customer = customerService.getCustomer(custID);
		
		logger.info("Retrieved " + customer.getFirstName() + " " + customer.getLastName());
		
		return customer;
	}
}
