package az.atlacademy.springjpaexample.controller;

import az.atlacademy.springjpaexample.dao.entity.ProductEntity;
import az.atlacademy.springjpaexample.model.dto.ProductDto;
import az.atlacademy.springjpaexample.model.request.CreateProductRequest;
import az.atlacademy.springjpaexample.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> addProduct(@Valid @RequestBody CreateProductRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProductById(@NotBlank @PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/name")
    public ResponseEntity<ProductDto> findProductByName(@NotBlank @RequestParam String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @PutMapping("/update")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody CreateProductRequest request) {
        return ResponseEntity.ok(productService.updateProduct(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@NotBlank @PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

}
