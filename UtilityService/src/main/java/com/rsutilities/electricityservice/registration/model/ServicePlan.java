package com.rsutilities.electricityservice.registration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "serviceplan")
public class ServicePlan {

	@Id
	@Column(name = "ID", nullable = false)
	private int serviceId;

	@Column(name = "SERVICE_PLAN", nullable = true)
	private String servicePlan;

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServicePlan() {
		return servicePlan;
	}

	public void setServicePlan(String servicePlan) {
		this.servicePlan = servicePlan;
	}

	@Override
	public String toString() {
		return "ServicePlan [serviceId=" + serviceId + ", servicePlan=" + servicePlan + "]";
	}
	
	

}
