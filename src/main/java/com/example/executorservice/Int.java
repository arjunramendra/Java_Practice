package com.example.executorservice;

public class Int{
	
	public class Employee{
		String name;
		int id;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		
	}
	
//	public static void main(String[] args) {
//
//		List<Employee> emp = new ArrayList<>();
//
//		emp.stream().filter(empl->empl.getName().startsWith('A')).collect(Collectors.toList());
//
//
//	}
	
}