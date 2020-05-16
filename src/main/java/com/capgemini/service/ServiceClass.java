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

public Product ProductCreation(Product prod) {
	return dao.ProductCreation(prod);
}

public Product delete(int id) 
{
	return dao.deleteById(id);
}

public Product UpdateProduct(Product prod) {
	return dao.UpdateProduct(prod);	
}
public List<Product> getAllProduct() 
{
return dao.getAllProduct();
}
}