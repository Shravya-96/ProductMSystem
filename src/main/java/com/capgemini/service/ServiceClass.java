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

public Product ProductCreation(Product p) {
	return dao.ProductCreation(p);
}

public Product getProductById(int productId) 
{
return dao.getProductById(productId);
}


public Product delete(int id) 
{
	return dao.deleteById(id);
}

public Product UpdateProduct(Product p) {
	return dao.UpdateProduct(p);	
}
public List<Product> getAllProduct() 
{
return dao.getAllProduct();
}
}
