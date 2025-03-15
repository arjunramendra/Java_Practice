package com.example.controller;

public interface test {

    public void test();

    public default void print(){
        System.out.println("Hello");
    }

}
