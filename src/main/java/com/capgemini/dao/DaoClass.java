package com.capgemini.dao;

import static org.junit.Assert.assertEquals;

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
	 EntityManager em;
	DaoClass dao;
	
	@Override
	public Product ProductCreation(Product prod) {

		Product product=em.merge(prod);
		return product;
	}
	
@Override
	public List<Product> getAllProduct() {
		Query q=em.createQuery("select m from Product m");
		List<Product> productlist=q.getResultList();
		return productlist;
	}
	@Override
	public Product UpdateProduct(Product prod) {
		Product product=em.find(Product.class,prod.getProductId());
		if(product!=null)
		{
			product.setProductName(prod.getProductName());
			product.setProductBrand(prod.getProductBrand());
			product.setProductPrice(prod.getProductPrice());
			
		}
		return product;
			
	}
	@Override	
	public Product deleteById(int productId) {
		Product product=em.find(Product.class,productId);
		if(product!=null)
			{em.remove(product);
			}
        return product;
	}
	}

