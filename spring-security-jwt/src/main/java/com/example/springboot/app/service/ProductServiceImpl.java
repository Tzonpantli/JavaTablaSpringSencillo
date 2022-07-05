package com.example.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.springboot.app.model.Product;
import com.example.springboot.app.repository.ProductRepository;

@Service //Notación para indicar que es un servicio
@Transactional //define que un conjunto de instrucciones que se ejecutan en bloque asegura y valida el metodo termine correctamente antes de ejecutar algun otro metodo
public class ProductServiceImpl implements ProductService {

	//Inyección de dependecias (crea una instancia cuando lo requiera)
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> productDb = this.productRepository.findById(product.getId());

		if (productDb.isPresent()) {
			Product productUpdate = productDb.get();
			productUpdate.setId(product.getId());//Id de prenda
			productUpdate.setApellido(product.getApellido());//tipo
			productUpdate.setNombre(product.getNombre());//usabilidad
			productUpdate.setNacio(product.getNacio());
			productUpdate.setLenguaje(product.getLenguaje());
			productUpdate.setAero(product.getAero());
			productRepository.save(productUpdate);
			return productUpdate;
		} else {
			throw new ResourceNotFoundException("No ha sido encontrado por id : " + product.getId());
		}
	}

	@Override
	public List<Product> getAllProduct() {
		return this.productRepository.findAll();
	}

	@Override
	public Product getProductById(long productId) {

		Optional<Product> productDb = this.productRepository.findById(productId);

		if (productDb.isPresent()) {
			return productDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + productId);
		}
	}

	@Override
	public void deleteProduct(long productId) {
		Optional<Product> productDb = this.productRepository.findById(productId);

		if (productDb.isPresent()) {
			this.productRepository.delete(productDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + productId);
		}

	}
}
