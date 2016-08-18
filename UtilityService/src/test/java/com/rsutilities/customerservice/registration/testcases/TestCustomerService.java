package com.rsutilities.customerservice.registration.testcases;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

import com.rsutilities.electricityservice.registration.model.Customer;
import com.rsutilities.electricityservice.registration.service.CustomerService;


public class TestCustomerService {

	@Test
	public void testGetCustomer() {
		Customer customer = new Customer();
		customer.setFirstName("Rohit");
		customer.setLastName("Kavoori");
		customer.setEmail("rohitkavoori@gmail.com");
		customer.setUsername("rkavoori");
		
		CustomerService rsg = Mockito.mock(CustomerService.class);
		
		when(rsg.getCustomerDetails(1)).thenReturn(customer);
		
		assertEquals(rsg.getCustomerDetails(1), customer);
	}
}
