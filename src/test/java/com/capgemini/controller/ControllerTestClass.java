package com.capgemini.controller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.capgemini.ProductManagementSystemApplication;
import com.capgemini.entity.Product;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductManagementSystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTestClass {
     @Autowired
     private TestRestTemplate restTemplate;

     @LocalServerPort
     private int port;

     private String getRootUrl() {
         return "http://localhost:" + port;
     }

     @Test
     public void contextLoads() {

     }

     @Test
     public void testGetAllProduct() {
     HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/products",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }


    @Test
    public void testProductCreation() {
        Product product = new Product();
        product.setProductId(101);
        product.setProductName("shoes");
        product.setProductBrand("nike");
        product.setProductPrice(1000);
        product.setRetailerId("R3");
        ResponseEntity<Product> postResponse = restTemplate.postForEntity(getRootUrl() + "/products", product, Product.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateProduct() {
        int productId = 101;
        Product product = restTemplate.getForObject(getRootUrl() + "/products/" + productId, Product.class);
        product.setProductName("watch");
        product.setProductBrand("roadster");
        product.setProductPrice(2000);
        product.setRetailerId("R32");
        restTemplate.put(getRootUrl() + "/products/" + productId, product);
        Product updateproduct = restTemplate.getForObject(getRootUrl() + "/products/" + productId, Product.class);
        assertNotNull(updateproduct);
    }

    @Test
    public void testDeleteProduct() {
    	int productId = 1;
         Product product = restTemplate.getForObject(getRootUrl() + "/products/" + productId, Product.class);
         assertNotNull(product);
         restTemplate.delete(getRootUrl() + "/products/" + productId);
         try {
        	 product = restTemplate.getForObject(getRootUrl() + "/products/" + productId, Product.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}
