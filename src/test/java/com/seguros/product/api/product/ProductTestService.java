package com.seguros.product.api.product;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.seguros.product.api.models.entity.Product;
import com.seguros.product.api.models.entity.ProductBuy;
import com.seguros.product.api.models.services.IProductService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTestService {

	@Autowired
	private IProductService productService;

	Product product;
	Product productSave;
	List<Product> listProduct;

	@Before
	public void setUp() throws Exception {
		product = new Product();
		product.setName("Borrador");
//		product.setStock(50);
//		product.setUnitValue(1000);

	}

	@Test
	public void saveTest() {

		try {
			productSave = productService.save(product);
			System.out.println(
					"nombre producto creado: " + productSave.getName() + " y su id es: " + productSave.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void listProductTest() {
		try {
			listProduct = productService.findAll();

			for (int i = 0; i < listProduct.size(); i++) {
				System.out.println("nombre producto: " + listProduct.get(i).getName());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void updateProductTest() {

		try {
			Product productUpdate = productService.findById(3);
			productUpdate.setName("Regla");
			productUpdate = productService.save(productUpdate);
			System.out.println("nombre producto actualizado: " + productUpdate.getName() + " y su id es: "
					+ productUpdate.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void toBuyTest() throws Exception {
		ProductBuy productBuy = productService.toBuy(2, 10);
		System.out.println("total: " + productBuy.getTotal());
	}

}
