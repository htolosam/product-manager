package com.seguros.product.api.models.entity;

/**
 * Clase para devolver la respuesta cuando se solicita la compra de una 
 * cantidad de productos, Se creo debido a que en la prueba la respuesta
 * solicita el total de la compra y los datos del producto
 * @author leanyspineda
 * @Since 17-06-2020
 */
public class ProductBuy {
	
	private Product product;
	private int quantity;
	private double total;
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

}
