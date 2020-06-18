package com.seguros.product.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.seguros.product.api.models.entity.Product;
import com.seguros.product.api.models.services.IProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Product product){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(e);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		try {
			return ResponseEntity.ok(productService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(e);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findByAId(@PathVariable int id){
		try {
			return ResponseEntity.ok(productService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(e);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Product product){
		try {
			return ResponseEntity.ok(productService.save(product));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(e);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id){
		try {
			 productService.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(e);
		}
	}
	
	@PutMapping("/toBuy/{id}/{cantidad}")
	public ResponseEntity<?> toBuy(@PathVariable int id, @PathVariable int cantidad){
		try {
			return ResponseEntity.ok(productService.toBuy(id, cantidad));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(e);
		}
	}
	
	

}
