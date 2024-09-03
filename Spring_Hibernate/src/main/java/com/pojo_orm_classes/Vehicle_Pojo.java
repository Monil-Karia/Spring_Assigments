package com.pojo_orm_classes;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//PARENT CLASS
@Entity  
@Table(name = "fis_inheritanceparentvehicle")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  //Inheritance Table Per Hierarchy

//distinguish the subclass records
@DiscriminatorColumn(name="Vehicletype",discriminatorType=DiscriminatorType.STRING,length=25)  

public class Vehicle_Pojo {
	/*
	 * @GeneratedValue defines how to generate value for the given column. 
	 * GenerationType.AUTO sets @GeneratedValue automatic.
	 */
	@Id   
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name = "ID")  	
	int ID;
	@Column(name = "Name")
	String Name;
	@Column(name = "LicenseNumber")
	int LicenseNumber;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getLicenseNumber() {
		return LicenseNumber;
	}
	public void setLicenseNumber(int licenseNumber) {
		LicenseNumber = licenseNumber;
	}
	

}
