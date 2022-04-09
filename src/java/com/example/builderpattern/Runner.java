package com.example.builderpattern;

import java.time.LocalDate;

public class Runner {

	public static void main(String[] args) {
		User user = createUser();
		UserDTOBuilder builder = new UserWebDTOBuilder();
		UserWebDTO dto  = directBuild(builder, user);
		System.out.println(dto);
		
	}
	
	private static UserWebDTO directBuild(UserDTOBuilder builder, User user) {
		return builder.withFirstName(user.getFirstName())
		.withLastName(user.getLastName())
		.withBirthday(user.getBirthday())
		.withAddress(user.getAddress()).build();
	}
	
	public static User createUser() {
		User user = new User();
		Address address = new Address();
		address.setCity("Pawnee");
		address.setHouseNumber("100");
		address.setState("Indiana");
		address.setStreet("State Street");
		address.setZipcode("47998");
		user.setAddress(address);
		user.setBirthday(LocalDate.of(1960, 5, 6));
		user.setFirstName("Ron");
		user.setLastName("Swanson");
		return user;
	}
	
}
