package com.seguros.product.api.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.seguros.product.api.models.entity.Product;

/**
 * 
 * @author leanyspineda
 * @since 17-06-2020
 */
public interface IProductDao extends CrudRepository<Product, Integer> {

}
