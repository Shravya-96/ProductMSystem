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
@RequestMapping("/product")
@CrossOrigin("http://localhost:4200")
public class ControllerClass {
	@Autowired
	ServiceClass serviceobj;

	// Create Employee
	@PostMapping("/ProductCreation")
	public ResponseEntity<String> ProductCreation(@RequestBody Product p) {
		Product e = serviceobj.ProductCreation(p);
		if (e == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Product created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	@GetMapping("/GetAllProducts")
	private ResponseEntity<List<Product>> getAllProduct() {
		List<Product> emplist = serviceobj.getAllProduct();
		return new ResponseEntity<List<Product>>(emplist, new HttpHeaders(), HttpStatus.OK);

	}
	@GetMapping("/SearchProduct/{id}")
	private ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
		Product e = serviceobj.getProductById(id);
		if (e == null) {
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		} else {
			return new ResponseEntity<Product>(e, new HttpHeaders(), HttpStatus.OK);
		}
	}
	@PutMapping("/UpdateProduct")
	public ResponseEntity<String> UpdateProduct(@RequestBody Product p) {
		Product e = serviceobj.UpdateProduct(p);
		if (e == null) {
			throw new IdNotFoundException("Update Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Product updated successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}
	@DeleteMapping("/DeleteProduct/{id}")
	private ResponseEntity<String> delEmp(@PathVariable("id") int id) {
		Product e = serviceobj.delete(id);
		if (e == null) {
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Product deleted successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}


}
