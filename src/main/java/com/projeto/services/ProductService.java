package com.projeto.services;

import com.projeto.model.ProductModel;
import com.projeto.model.ProductStatus;
import com.projeto.dtos.ProductDTO;
import com.projeto.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    
    public ProductModel findProductById(Long id) throws Exception {
        return this.repository.findProductById(id).orElseThrow(() -> new Exception("Produto não encontrado"));
    }

    public ProductModel createProduct(ProductDTO data) {
        ProductModel newUser = new ProductModel(data);
        this.saveProduct(newUser);
        return newUser;
    }


    public String inactivateProductById(Long id) throws Exception {
        Optional<ProductModel> productOptional = repository.findById(id);
        if (productOptional.isPresent()) {
            ProductModel product = productOptional.get();
            product.setProductStatus(ProductStatus.INACTIVE);
            repository.save(product);
            return "Produto com ID " + id + " foi inativado com sucesso.";
        } else {
            throw new Exception("Produto não encontrado");
        }
    }
    
    public ProductModel updateProduct(Long id, ProductModel newProduct) throws Exception {
        Optional<ProductModel> existingProductOptional = repository.findById(id);
        if (!existingProductOptional.isPresent()) {
            throw new Exception("Produto não encontrado");
        }

        ProductModel existingProduct = existingProductOptional.get();

        if (newProduct.getName() != null) {
            existingProduct.setName(newProduct.getName());
        }
        if (newProduct.getType() != null) {
            existingProduct.setType(newProduct.getType());
        }
        if (newProduct.getQuantity() != null) {
            existingProduct.setQuantity(newProduct.getQuantity());
        }
        if (newProduct.getSize() != null) {
            existingProduct.setSize(newProduct.getSize());
        }
        if (newProduct.getProductStatus() != null) {
            existingProduct.setProductStatus(newProduct.getProductStatus());
        }

        return repository.save(existingProduct);
    }


    public List<ProductModel> getAllProducts() {
        return this.repository.findAll();
    }

    public void saveProduct(ProductModel productModel) {
        this.repository.save(productModel);
    }
}


