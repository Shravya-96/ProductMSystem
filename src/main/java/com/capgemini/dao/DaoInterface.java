package com.capgemini.dao;



import java.util.List;

import com.capgemini.entity.Product;


public interface DaoInterface {

	Product deleteById(int productid);
	
	List<Product> getAllProduct();


	Product getProductById(int productid);

	Product UpdateProduct(Product p);

	Product ProductCreation(Product p);
}