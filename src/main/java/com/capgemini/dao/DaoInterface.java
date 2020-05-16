package com.capgemini.dao;



import java.util.List;

import com.capgemini.entity.Product;


public interface DaoInterface {

	Product deleteById(int productId);
	
	List<Product> getAllProduct();


	

	Product UpdateProduct(Product updateproduct);

	Product ProductCreation(Product addproduct);
}