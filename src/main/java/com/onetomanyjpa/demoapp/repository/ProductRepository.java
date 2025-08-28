package com.onetomanyjpa.demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetomanyjpa.demoapp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

}
