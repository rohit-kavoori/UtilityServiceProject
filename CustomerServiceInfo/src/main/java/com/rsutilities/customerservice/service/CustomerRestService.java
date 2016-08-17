package com.rsutilities.customerservice.service;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rsutilities.customerservice.dao.CustomerServiceDAO;
import com.rsutilities.customerservice.model.Customer;


@Path("/customer")
public class CustomerRestService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@HeaderParam(value = "content-type = application/octet-stream")
	@Path("/{param}")
	public Customer getCustomer(@PathParam("param") int custID) {
		Customer customer = CustomerServiceDAO.getCustomer(custID);
		return customer;
	}
}
