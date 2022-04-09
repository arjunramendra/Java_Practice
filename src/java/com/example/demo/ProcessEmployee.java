package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class ProcessEmployee {

	public static void main(String[] args) {
		processEmp();
	}
	
	public static void processEmp() {
		EmpProcess empMadhu = formEmpObj(1,"Madhu");
		EmpProcess empArjun = formEmpObj(1,"Arjun");
		
		Map<EmpProcess, String> emp = new HashMap<>();
		emp.put(empMadhu, empMadhu.getName());
		emp.putIfAbsent(empArjun, empArjun.getName());
		
		System.out.println(emp);
		
	}
	
	public static EmpProcess formEmpObj(int id, String name) {
		EmpProcess empProcess = new EmpProcess();
		empProcess.setId(id);
		empProcess.setName(name);
		return empProcess;
	}

	
}
