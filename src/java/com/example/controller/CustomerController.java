package com.example.controller;

import com.example.models.Customers;
import com.example.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

	//@Qualifier("cat")
	@Autowired
	private Animal animal;
	
    @Autowired
    private CustomersRepository customerRepository;

    @GetMapping("/getCustomers")
    public List<Customers> getAllCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping(value = "/addCustomer", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Customers> addCustomer(@RequestBody final Customers customers){
        customerRepository.save(customers);
        return customerRepository.findAll();
    }

    @GetMapping("/getCustomer/{id}")
    public Optional<Customers> getCustomerById(@PathVariable int id){
        return customerRepository.findById(id);
    }
    
    @GetMapping("/primary")
    public String qualifierExample() {
    	return animal.sound();
    }
    
    public static void main(String[] args) {
    	String[] str = {"safe", "sorry", "sife"};
    	List<String> strList = Arrays.asList(str);
    	Optional<String> strSE  = strList.stream().filter(p -> p.startsWith("s") && p.endsWith("e")).findAny();
    	System.out.println(strSE);
    	
//    	CustomAnnotation ann = new CustomAnnotation();
//    	Class c = ann.getClass();
//    	Annotation an = c.getAnnotation(customAnnotation.class);
//    	customAnnotation annotation = (customAnnotation)an; 
//    	System.out.println(annotation.name() + " & " +annotation.name());
     }
    
    
}
