package com.onetomanyjpa.demoapp.services;

import java.util.List;



import com.onetomanyjpa.demoapp.dto.OrderRequest;
import com.onetomanyjpa.demoapp.entity.Customer;
import com.onetomanyjpa.demoapp.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServices {
	
	private final CustomerRepository customerRepository;

    public Customer placeOrderLogic(OrderRequest request){
        log.info("Order Placed Successfully");
        return customerRepository.save(request.getCustomer());
    }
    public List<Customer> findAllOrderDetails(){
        log.info("Fetching all Order Details");
        return customerRepository.findAll();
    }
    public List<OrderResponse> getCustomerAndProducts(){
        log.info("Combine customer and product details");
        return customerRepository.getJoinInfo();
    }

}
