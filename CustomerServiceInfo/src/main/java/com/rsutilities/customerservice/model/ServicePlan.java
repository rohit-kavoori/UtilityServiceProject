package com.rsutilities.customerservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Rohit Kavoori
 * Entity class for service plan
 */
@Entity
@Table(name = "serviceplan")
public class ServicePlan {
	
	@Id
	@Column(name="ID", nullable = false)
	private int serviceId;
	
	@Column(name="SERVICE_PLAN",nullable = true)
	private String servicePlan;
	/**
	 * @return the serviceId
	 */
	public int getServiceId() {
		return serviceId;
	}
	/**
	 * @return the servicaplan
	 */
	public String getServiceplan() {
		return servicePlan;
	}
	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	/**
	 * @param servicePlan the serviceplan to set
	 */
	public void setServiceplan(String servicePlan) {
		this.servicePlan = servicePlan;
	}
}
