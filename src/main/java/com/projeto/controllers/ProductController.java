package com.projeto.controllers;

import com.projeto.dtos.ProductDTO;
import com.projeto.model.ProductModel;
import com.projeto.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductDTO product) {
        ProductModel newUser = productService.createProduct(product);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        List<ProductModel> products = this.productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable Long id) {
        try {
            ProductModel product = this.productService.findProductById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> inactivateProductById(@PathVariable Long id) {
        try {
            String message = productService.inactivateProductById(id);
            return ResponseEntity.ok(message);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable Long id, @RequestBody ProductModel newProduct) {
        try {
            ProductModel updatedProduct = productService.updateProduct(id, newProduct);
            return ResponseEntity.ok(updatedProduct);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
