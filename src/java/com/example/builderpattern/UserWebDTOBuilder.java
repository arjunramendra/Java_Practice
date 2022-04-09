package com.example.builderpattern;

import java.time.LocalDate;
import java.time.Period;

public class UserWebDTOBuilder implements UserDTOBuilder{

	private String firstName;
	private String lastName;
	private String age;
	private String address;
	private UserWebDTO dto;
	
	@Override
	public UserDTOBuilder withFirstName(String fName) {
		firstName = fName;
		return this;
	}

	@Override
	public UserDTOBuilder withLastName(String lName) {
		lastName = lName;
		return this;
	}

	@Override
	public UserDTOBuilder withBirthday(LocalDate date) {
		Period ageInYears = Period.between(date, LocalDate.now());
		age = Integer.toString(ageInYears.getYears());
		return this;
	}

	@Override
	public UserDTOBuilder withAddress(Address address) {
		this.address = address.getHouseNumber() + ", " + address.getStreet() + ", " + 
				address.getCity() + ", " + address.getState() + ", " + address.getZipcode();
		return this;
	}

	@Override
	public UserWebDTO build() {
		dto = new UserWebDTO(firstName + " " + lastName, address, age);
		return dto;
	}

	@Override
	public UserWebDTO getUserDTO() {
		return dto;
	}

}
