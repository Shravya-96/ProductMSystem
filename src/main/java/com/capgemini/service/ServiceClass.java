package com.capgemini.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.entity.Product;

import com.capgemini.dao.DaoClass;

@Service
@Transactional
public class ServiceClass 
{
@Autowired
DaoClass dao;

public Product ProductCreation(Product addproduct) {
	return dao.ProductCreation(addproduct);
}

public Product delete(int productId) 
{
	return dao.deleteById(productId);
}

public Product UpdateProduct(Product updateproduct) {
	return dao.UpdateProduct(updateproduct);	
}
public List<Product> getAllProduct() 
{
return dao.getAllProduct();
}
}