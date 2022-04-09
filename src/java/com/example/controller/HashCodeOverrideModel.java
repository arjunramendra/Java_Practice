package com.example.controller;

public class HashCodeOverrideModel {

	private int id;
	
	private int name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + name;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashCodeOverrideModel other = (HashCodeOverrideModel) obj;
		if (id != other.id)
			return false;
		if (name != other.name)
			return false;
		return true;
	}
}
