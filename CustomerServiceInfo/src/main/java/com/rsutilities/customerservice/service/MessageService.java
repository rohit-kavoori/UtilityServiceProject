package com.rsutilities.customerservice.service;

import com.rsutilities.customerservice.dao.MessageServiceDAO;

public class MessageService {

	
	public int setCustomerService(int c_id, int serv_id) {
	
		MessageServiceDAO messageServiceDao = new MessageServiceDAO();
		int rowUpdate = messageServiceDao.saveCustomerService(c_id, serv_id);
		return rowUpdate;
	}
}
