package com.example.springboot.app.service;

import java.util.List;

import com.example.springboot.app.model.Product;

/**
 * Interfaz con los metodos que seran utilizados para relizar los metodos de un CRUD
 * @author Usuario
 *
 */
public interface ProductService {

	/**
	 * Metodo para crear un nuevo producto, el cual espera un objeto de la clase Product
	 * El cual contendra todos los datos del producto que se insertara en la tabla products
	 * previamente definida en la clase con la anotacion @Entity
	 * @param product
	 * @return
	 */
	Product createProduct(Product product);

	/**
	 * Metodo para actualizar  un producto el cual espera como parametro un objeto de la clase Product
	 * Este Objeto debe contener los nuevos datos del producto. que se va a actualizar 
	 * 
	 * @param product
	 * @return
	 */
	Product updateProduct(Product product);
	
	/**
	 * Obtiene de la Base de datos todos los productos registrados en la tabla products
	 * 
	 * @return
	 */
	List<Product> getAllProduct();

	/**
	 * Obtiene el detale de un producto en especifico a traves de su ID
	 * 
	 * @param productId
	 * @return
	 */
	Product getProductById(long productId);

	/**
	 * Elimina un producto de la tabla products, a traves de su ID
	 * @param id
	 */
	void deleteProduct(long id);
}
