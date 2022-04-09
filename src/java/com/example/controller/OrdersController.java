package com.example.controller;

import com.example.models.Orders;
import com.example.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    OrdersRepository ordersRepository;

    @GetMapping("/getOrders")
    public List<Orders> getAllOrders(){
        return ordersRepository.findAll();
    }

}
