package com.seguros.product.api.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguros.product.api.constant.ErrorConstant;
import com.seguros.product.api.models.dao.IProductDao;
import com.seguros.product.api.models.entity.Product;
import com.seguros.product.api.models.entity.ProductBuy;
import com.seguros.product.api.models.services.IProductService;

/**
 * 
 * @author leanyspineda
 * @since 17-06-2020
 */
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductDao productDao;

	@Override
	public Product save(Product product) throws Exception {
		
		try {
//			if(productDao.existsById(product.getId()) && product.getId()>0 ) {
//				
//			}
			return productDao.save(product);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Product> findAll() throws Exception {
		try {
			return (List<Product>) productDao.findAll();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Product findById(int id) throws Exception {
		try {
			if (productDao.existsById(id)) {
				return productDao.findById(id).orElse(null);
			} else {
				throw new Exception(ErrorConstant.ERROR_ID_PRODUCT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void deleteById(int id) throws Exception {
		try {
			if (productDao.existsById(id)) {
				productDao.deleteById(id);
			} else {
				throw new Exception(ErrorConstant.ERROR_ID_PRODUCT_NOT_FOUND);
			}
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public ProductBuy toBuy(int id, int cantidad) throws Exception {
		ProductBuy productBuy = new ProductBuy();
		if(productDao.existsById(id)) {
			Product productToBuy = productDao.findById(id).orElse(null);
			if(productToBuy.getStock() > cantidad) {
				productBuy.setProduct(productToBuy);
				productBuy.setQuantity(cantidad);
				productBuy.setTotal(productToBuy.getUnitValue() * cantidad);
				
				productToBuy.setStock(productToBuy.getStock()- cantidad);
				productDao.save(productToBuy);
			}else {
				throw new Exception(ErrorConstant.ERROR_STOCK_PRODUCT_INSUFFICIENT);
			}
		}
		return productBuy;
	}

}
