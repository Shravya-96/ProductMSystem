package com.capgemini.controller;
import com.capgemini.entity.Product;
import com.capgemini.service.ServiceClass;

import com.capgemini.exceptions.IdNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:4200")
public class ControllerClass {
	@Autowired
	ServiceClass serviceobj;

//Adding product details to the product table
	@PostMapping("/ProductCreation")
	public ResponseEntity<String> ProductCreation(@RequestBody Product addproduct) {
		Product product = serviceobj.ProductCreation(addproduct);
		if (product == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Product created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	//Displays list of all products
	@GetMapping("/GetAllProduct")
	private ResponseEntity<List<Product>> getAllProduct() {
		List<Product> productlist = serviceobj.getAllProduct();

		return new ResponseEntity<List<Product>>(productlist, new HttpHeaders(), HttpStatus.OK);
	}
	
	//Updating the product details
	@PutMapping("/UpdateProduct")
	public ResponseEntity<String> UpdateProduct(@RequestBody Product updateproduct) {
		Product product = serviceobj.UpdateProduct(updateproduct);
		if (product == null) {
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Product updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	//Deleting the particular product from the list
	@DeleteMapping("/DeleteProduct/{id}")
	private ResponseEntity<String> delEmp(@PathVariable("id") int productId) {
		Product product = serviceobj.delete(productId);
		if (product == null) {
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Product deleted successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@ExceptionHandler(IdNotFoundException.class)
	
	public ResponseEntity<String> userNotFound(IdNotFoundException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}


}
