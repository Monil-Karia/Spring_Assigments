
package com.pojo_orm_classes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//SUB CLASS

@Entity  
@DiscriminatorValue("MKTwo_Wheeler") //empstype=Permanent_employee
public class TwoWheeler_Pojo  extends Vehicle_Pojo //2+2 =4 PROPERTIES
{
	@Column(name="steeringHandle")    	
	String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

	
}

