package com.capgemini.dao;



import java.util.List;

import com.capgemini.entity.Product;


public interface DaoInterface {

	Product deleteById(int productid);
	
	List<Product> getAllProduct();


	

	Product UpdateProduct(Product prod);

	Product ProductCreation(Product prod);
}