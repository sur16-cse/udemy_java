package com.surbhi.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;

import com.surbhi.springdata.product.entites.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
