package com.capgemini.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import com.capgemini.entity.Product;

@Repository
@Transactional
public class DaoClass implements DaoInterface {

	@PersistenceContext	
	 EntityManager entitymanager;
	DaoClass dao;
	
	@Override
	public Product ProductCreation(Product addproduct) {

		Product product=entitymanager.merge(addproduct);
		return product;
	}
	
@Override
	public List<Product> getAllProduct() {
		Query q=entitymanager.createQuery("select m from Product m");
		List<Product> productlist=q.getResultList();
		return productlist;
	}
	@Override
	public Product UpdateProduct(Product updateproduct) {
		Product product=entitymanager.find(Product.class,updateproduct.getProductId());
		if(product!=null)
		{
			product.setProductName(updateproduct.getProductName());
			product.setProductBrand(updateproduct.getProductBrand());
			product.setProductPrice(updateproduct.getProductPrice());
			
		}
		return product;
			
	}
	@Override	
	public Product deleteById(int productId) {
		Product product=entitymanager.find(Product.class,productId);
		if(product!=null)
			{entitymanager.remove(product);
			}
        return product;
	}
	}

