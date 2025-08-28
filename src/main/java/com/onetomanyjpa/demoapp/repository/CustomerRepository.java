package com.onetomanyjpa.demoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onetomanyjpa.demoapp.dto.OrderResponse;
import com.onetomanyjpa.demoapp.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	@Query( "SELECT c.name AS name, c.email AS email, p.productName AS productName, p.qty AS quantity FROM Customer c JOIN c.products p")
    List<OrderResponse> getJoinInfo();
}
