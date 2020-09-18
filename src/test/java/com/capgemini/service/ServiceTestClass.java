package com.capgemini.service;

import static org.junit.Assert.assertNotNull;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.ProductManagementSystemApplication;
import com.capgemini.dao.DaoClass;
import com.capgemini.entity.Product;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductManagementSystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceTestClass {
     
     @Autowired
     DaoClass daoobj;
     
     @Test
     public void contextLoads() {

     }
     @Test
     public void testProductCreation()
     {
		Product addproduct=new Product();
    	daoobj.ProductCreation(addproduct);
    	assertNotNull(addproduct);
     }
     
	@Test
     public void testGetAllProduct()
     {
    	 List<Product> listproduct=daoobj.getAllProduct();
    	 assertNotNull(listproduct);
     }
     @Test
     public void testUpdateProduct()
     {
    	 Product updateproduct=new Product();
    	 daoobj.UpdateProduct(updateproduct);
    	 assertNotNull(updateproduct);
     }
     @Test
     public void testDeleteProduct()
     {
    	 Product deleteproduct=new Product();
    	 int productId=100;
    	 daoobj.deleteById(productId);
    	 assertNotNull(deleteproduct);
     }
}