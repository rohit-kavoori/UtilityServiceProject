package com.ekthasol.utilityservice.registration.testcases;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.ekthasol.utilityservice.registration.model.Customer;
import com.ekthasol.utilityservice.registration.service.RegistrationService;

public class MockitoTestCase {

	@Test
	public void testGetCustomer() {
		Customer customer = new Customer();
		customer.setFirstName("Rohit");
		customer.setLastName("Kavoori");
		customer.setEmail("rohitkavoori@gmail.com");
		customer.setUsername("rkavoori");
		
		RegistrationService rsg = Mockito.mock(RegistrationService.class);
		
		when(rsg.getCustomerDetails(1)).thenReturn(customer);
		
		assertEquals(rsg.getCustomerDetails(1), customer);
	}
}
