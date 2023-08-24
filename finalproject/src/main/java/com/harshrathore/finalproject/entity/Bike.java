package com.harshrathore.finalproject.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@Table(name = "BikeServiceDetails")
@SequenceGenerator(name = "my_entity_seq", sequenceName = "my_entity_seq_db", allocationSize = 1)
public class Bike {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "my_entity_seq")
private Integer id;
@Size(min=3,message = "Maker Name must have 3 characters")
@NotNull(message = "Maker name cannot be null")
private String maker_name;
@NotNull(message = "Model name cannot be null")
@Size(min=2,message = "Model must have atleast 2 characters")
private String model_name;
@NotNull(message = "Registration cannot be null")
@Size(min=10,max=10,message = "Registration Number must have 10 characters")
private String registration_Number;
@NotNull(message = "Chasis Number cannot be null")
@Max(value = 99999 , message =   "Chasis Number Cannot be more than 5 digits")
private  Number chasis_number;
@Size(min=4,message = "Known issue description should atleast have 5 characters")
@NotNull(message = "Known issues cannot be null")
private String known_issues;
@NotNull(message = "Cost cannot be null")
private Number cost;
@NotNull(message = "Given Date  Cannot be Null")
private LocalDateTime given_date;
@NotNull(message = "Expected Delivery Date Cannot be Null")
@Future(message = "Expected delivery Date must be in the future")
private LocalDate expected_deliveydate;
@NotNull(message = "Created DateTime Cannot be Null")
private LocalDateTime created_DateTime;
@NotNull(message = "Updated DateTime Cannot be Null")
private LocalDateTime updated_DateTime;
@NotNull(message = "Address Cannot be Null")
@Size(min=1,message = "Address Cannot be Null")
private String address;
@NotNull(message = "Phone number Cannot be Null")
@Size(min = 10,max=10,message="Phone number must be at least 10 digits")
private String phone_number;
public String getMaker_name() {
	return maker_name;
}
public void setMaker_name(String bike_name) {
	this.maker_name = bike_name;
}
public String getModel_name() {
	return model_name;
}
public void setModel_name(String model_name) {
	this.model_name = model_name;
}
public String getRegistration_Number() {
	return registration_Number;
}
public void setRegistration_Number(String registration_Number) {
	this.registration_Number = registration_Number;
}
public Number getChasis_number() {
	return chasis_number;
}
public void setChasis_number(int chasis_number) {
	this.chasis_number = chasis_number;
}
public String getKnown_issues() {
	return known_issues;
}
public void setKnown_issues(String known_issues) {
	this.known_issues = known_issues;
}
public Number getCost() {
	return cost;
}
public void setCost(Number cost) {
	this.cost = cost;
}
public LocalDateTime getGiven_date() {
	return given_date;
}
public void setGiven_date(LocalDateTime given_date) {
	this.given_date = given_date;
}
public LocalDate getExpected_deliveydate() {
	return expected_deliveydate;
}
public void setExpected_deliveydate(LocalDate expected_deliveydate) {
	this.expected_deliveydate = expected_deliveydate;
}
public LocalDateTime getCreated_DateTime() {
	return created_DateTime;
}
public void setCreated_DateTime(LocalDateTime created_deliveryDateTime) {
	this.created_DateTime = created_deliveryDateTime;
}
public LocalDateTime getUpdated_DateTime() {
	return updated_DateTime;
}
public void setUpdated_DateTime(LocalDateTime updated_deliveryDateTime) {
	this.updated_DateTime = updated_deliveryDateTime;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhone_number() {
	return phone_number;
}
public void setPhone_number(String phone_number) {
	this.phone_number = phone_number;
}
public Bike(String bike_name, String model_name, String registration_Number, int chasis_number, String known_issues,
		double cost, LocalDateTime given_date, LocalDate expected_deliveydate, LocalDateTime created_deliveryDateTime,
		LocalDateTime updated_deliveryDateTime, String address, String phone_number) {
	super();
	this.maker_name = bike_name;
	this.model_name = model_name;
	this.registration_Number = registration_Number;
	this.chasis_number = chasis_number;
	this.known_issues = known_issues;
	this.cost = cost;
	this.given_date = given_date;
	this.expected_deliveydate = expected_deliveydate;
	this.created_DateTime = created_deliveryDateTime;
	this.updated_DateTime = updated_deliveryDateTime;
	this.address = address;
	this.phone_number = phone_number;
}
public Bike() {
	super();
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
@Override
public String toString() {
	return "Bike [id=" + id + ", maker_name=" + maker_name + ", model_name=" + model_name + ", registration_Number="
			+ registration_Number + ", chasis_number=" + chasis_number + ", known_issues=" + known_issues + ", cost="
			+ cost + ", given_date=" + given_date + ", expected_deliveydate=" + expected_deliveydate
			+ ", created_DateTime=" + created_DateTime + ", updated_DateTime="
			+ updated_DateTime + ", address=" + address + ", phone_number=" + phone_number + "]";
}




}
