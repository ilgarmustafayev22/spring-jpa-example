package az.atlacademy.springjpaexample.service;

import az.atlacademy.springjpaexample.exception.ProductNotFoundException;
import az.atlacademy.springjpaexample.model.Product;
import az.atlacademy.springjpaexample.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with id - " + id + " not found!"));
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name).orElseThrow(() -> new ProductNotFoundException("Product with name - " + name + " not found!"));
    }

    public Product updateProduct(Product product) {
        Product existProduct = productRepository.findById(product.getId()).orElse(null);
        existProduct.setName(product.getName());
        existProduct.setCategory(product.getCategory());
        existProduct.setPrice(product.getPrice());
        return productRepository.save(existProduct);
    }

    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "product was deleted with id = " + id;
    }

}
