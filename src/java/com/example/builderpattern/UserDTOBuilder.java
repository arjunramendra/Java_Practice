package com.example.builderpattern;

import java.time.LocalDate;

public interface UserDTOBuilder {

	UserDTOBuilder withFirstName(String fName);
	UserDTOBuilder withLastName(String lName);
	UserDTOBuilder withBirthday(LocalDate date);
	UserDTOBuilder withAddress(Address address);
	UserWebDTO build();
	UserWebDTO getUserDTO();
	
}
