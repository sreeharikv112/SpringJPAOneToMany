package com.onetomanyjpa.demoapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onetomanyjpa.demoapp.dto.OrderRequest;
import com.onetomanyjpa.demoapp.entity.Customer;
import com.onetomanyjpa.demoapp.services.OrderServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderServices orderServices;

    @PostMapping("/placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer placeOrder(@RequestBody OrderRequest request){
        return orderServices.placeOrderLogic(request);
    }

    @GetMapping("/findAllOrders")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> findAllOrder(){
        return orderServices.findAllOrderDetails();
    }

    @GetMapping("/getCustomerAndProductInfo")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getCombinedCustomerAndProductInfo(){
        return orderServices.getCustomerAndProducts();
    }

}
