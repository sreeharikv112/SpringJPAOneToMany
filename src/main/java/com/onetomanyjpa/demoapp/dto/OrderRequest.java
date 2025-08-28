package com.onetomanyjpa.demoapp.dto;

import com.onetomanyjpa.demoapp.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class OrderRequest {

   private Customer customer;
}