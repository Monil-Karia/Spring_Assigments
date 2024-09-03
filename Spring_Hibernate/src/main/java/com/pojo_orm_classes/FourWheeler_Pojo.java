package com.pojo_orm_classes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//SUB CLASS

@Entity  
@DiscriminatorValue("MKFour_Wheeler") //empstype=Permanent_employee
public class FourWheeler_Pojo  extends Vehicle_Pojo //2+2 =4 PROPERTIES
{
	@Column(name="steeringWheel")    	
	String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
}
