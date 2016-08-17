package com.rsutilities.electricityservice.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rsutilities.electricityservice.registration.model.Customer;
import com.rsutilities.electricityservice.registration.service.RegistrationService;


@Controller
public class RegistrationController {

	@Autowired
	RegistrationService registrationSerivce;

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public ModelAndView handleRequest(@ModelAttribute("customer") Customer customer) {

		String status = registrationSerivce.saveCustomer(customer);
		if (!"notRegistered".equals(status))
			return new ModelAndView("result","status",status);
		else
			return new ModelAndView("failure", "message", "Sorry, could not register. Please try again later!!!");
	}

}
