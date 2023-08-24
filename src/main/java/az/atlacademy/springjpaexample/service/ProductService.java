package az.atlacademy.springjpaexample.service;

import az.atlacademy.springjpaexample.dao.repository.ProductRepository;
import az.atlacademy.springjpaexample.exception.ProductNotFoundException;
import az.atlacademy.springjpaexample.dao.entity.ProductEntity;
import az.atlacademy.springjpaexample.mapper.ProductMapper;
import az.atlacademy.springjpaexample.model.dto.ProductDto;
import az.atlacademy.springjpaexample.model.request.CreateProductRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Log4j2
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Transactional
    public ProductDto createProduct(CreateProductRequest request) {
        final ProductEntity productEntity = ProductEntity.builder()
                .name(request.getName())
                .price(request.getPrice())
                .category(request.getCategory())
                .build();
        log.info("Product added: [{}]", productEntity);
        ProductEntity savedEntity = productRepository.save(productEntity);
        log.info("Product added: [{}]", savedEntity);
        return productMapper.toDto(savedEntity);
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ProductNotFoundException("Product with id - " + id + " not found!"));
    }

    public ProductDto getProductByName(String name) {
        return productRepository.findByName(name)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ProductNotFoundException("Product with name - " + name + " not found!"));
    }

    @Transactional
    public ProductDto updateProduct(CreateProductRequest request) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();
        log.info(productEntity + "->");
        ProductEntity existProductEntity = productRepository.findByName(productEntity.getName()).orElse(null);
        existProductEntity.setPrice(productEntity.getPrice());
        log.info("-> [{}]:", existProductEntity);
        return productMapper.toDto(existProductEntity);
    }

    public String deleteProduct(long id) {
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        log.info("The product has been deleted [{}]:", productEntity);
        productRepository.deleteById(id);
        return "Product was deleted with id = " + id;
    }

}
