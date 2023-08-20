package az.atlacademy.springjpaexample.controller;

import az.atlacademy.springjpaexample.model.Product;
import az.atlacademy.springjpaexample.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Product> findProductById(@NotBlank @PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/findByName/{name}")
    public Product findProductByName(@NotBlank @PathVariable String name) {
        return productService.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteProduct(@NotBlank @PathVariable Long id) {
        return productService.deleteProduct(id);
    }

}
