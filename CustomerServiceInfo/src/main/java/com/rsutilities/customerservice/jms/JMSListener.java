package com.rsutilities.customerservice.jms;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import com.rsutilities.customerservice.service.MessageService;

/**
 * @author Rohit Kavoori
 * JMS Listener class to retrieve the messages from the sender and 
 * update service id for the given customer id.
 */
@Component("JMSListener")
public class JMSListener implements SessionAwareMessageListener<TextMessage> {

	/**
	 * Method to listen to the messages from the sender and 
	 * update service id for the given customer id.
	 */
	@Override
	public void onMessage(TextMessage message, Session session) throws JMSException {
		
		if (message instanceof TextMessage) {
			String msg;

			msg = ((TextMessage) message).getText();

			String[] msgAry = msg.split(" ");

			int c_id = Integer.parseInt(msgAry[0]);
			int serv_id = Integer.parseInt(msgAry[1]);

			MessageService messageService = new MessageService();
			messageService.setCustomerService(c_id, serv_id);

			/*
			 * ActiveMQTextMessage textMessage = new ActiveMQTextMessage(); if
			 * (update > 0 ) textMessage.setText("ACK"); else
			 * textMessage.setText("Failed to insert");
			 * 
			 * MessageProducer producer =
			 * session.createProducer(message.getJMSReplyTo());
			 * producer.send(textMessage);
			 */
		}
	}
}