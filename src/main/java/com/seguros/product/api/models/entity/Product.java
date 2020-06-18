package com.seguros.product.api.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * entidad que mapea la tabla productos de la base de datos ventas_seguros_alfa
 * @author leanyspineda
 * @since 17-06-2020
 */
@Entity
@Table(name = "productos")
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private int id;
	
	@Size(max = 20)
	@NotEmpty
	@Column(name = "nombre_producto")
	private String name;
	
	private int stock;
	
	@Column(name = "valor_unitario")
	private double unitValue;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * @return the unitValue
	 */
	public double getUnitValue() {
		return unitValue;
	}

	/**
	 * @param unitValue the unitValue to set
	 */
	public void setUnitValue(double unitValue) {
		this.unitValue = unitValue;
	}
	

}
