package com.example.controller;

import com.example.models.Products;
import com.example.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductsController {

    @Autowired
    ProductsRepository productsRepository;

    @GetMapping("/getProducts")
    public List<Products> getAllProducts(){
        return productsRepository.findAll();
    }

    @GetMapping("/getProduct/{id}")
    public Optional<Products> getProductById(@PathVariable int id){
        return productsRepository.findById(id);
    }

}
