package com.example.springboot.controllers;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {//Ele vai receber esse post esses valores, com o @Valid, vai ter validações
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);//Conversão de um para o outro
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id) {
        Optional<ProductModel> produtoO = productRepository.findById(id);
        if(produtoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoO.get());
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid ProductRecordDto productRecordDto) {
        Optional<ProductModel> product = productRepository.findById(id);
        if(product.isEmpty()) { //Verificar se existe
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var productModel = product.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id) {
        Optional<ProductModel> produtoO = productRepository.findById(id);
        if(produtoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        productRepository.delete(produtoO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }
}
