package com.surbhi.springdata.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.surbhi.springdata.product.entites.Product;
import com.surbhi.springdata.product.repos.ProductRepository;

@SpringBootTest
class ProductdataApplicationTests {
	@Autowired
	ProductRepository repository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreate() {
		Product product=new Product();
		product.setId(1);
		product.setName("IPhone");
		product.setDesc("Awesome");
		product.setPrice(1000d);
		repository.save(product);
	}
	
	@Test
	void testRead() {
		Product product=repository.findById(1).get();
		assertNotNull(product);
		assertEquals("IPhone", product.getName());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>"+product.getDesc());
	}
	
	@Test
	void testUpdate() {
		Product product=repository.findById(1).get();
		product.setPrice(1200d);
		repository.save(product);
	}

	
	@Test
	void testDelete() {
		if(repository.existsById(1)) {
			System.out.println("Deleting a product");
		repository.deleteById(1);
		
		}
	}
	
	@Test
	void testCount() {
		System.out.println("Total records>>>>>>>>>"+repository.count());
	}
}
