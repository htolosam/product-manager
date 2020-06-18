package com.seguros.product.api.models.services;

import java.util.List;

import com.seguros.product.api.models.entity.Product;
import com.seguros.product.api.models.entity.ProductBuy;

public interface IProductService {
	/**
	 * metodo para guardar un nuevo producto
	 * 
	 * @param product
	 * @return devuelve la entidad del producto creado
	 * @throws Exception
	 */
	public Product save(Product product) throws Exception;

	/**
	 * Metodo para retornar en una lista todos los productos que existen en la base
	 * de datos
	 * 
	 * @return una lista de objetos tipo Product
	 * @throws Exception
	 */
	public List<Product> findAll() throws Exception;
	
	
	/**
	 * Metodo para retornar un producto por medio de su id
	 * @param id
	 * @return un objeto tipo Product
	 * @throws Exception
	 */
	public Product findById(int id) throws Exception;
	
	/**
	 * Metodo para eliminar un producto que existe en la base de datos
	 * @param id
	 * @throws Exception
	 */
	public void deleteById(int id) throws Exception;
	
	/**
	 * metodo para realizar la compra de un producto, retornando el producto con 
	 * el valor total de la compra del producto, si n hay suficiente stock se devuelte un mensaje de alerta
	 * @param id
	 * @param cantidad
	 * @return un objeto tipo Producto con el total
	 * @throws Exception
	 */
	public ProductBuy toBuy(int id, int cantidad)throws Exception;

}
