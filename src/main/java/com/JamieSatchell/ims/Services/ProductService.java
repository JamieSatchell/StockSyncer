package com.JamieSatchell.ims.Services;

import com.JamieSatchell.ims.domain.Product;
import com.JamieSatchell.ims.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }


    public Product addProduct(Product product) {
        return productRepository.save(product); // Saving the new product instance to the database
    }

    public void deleteProductById(Long id) throws Exception {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()) {
            Product product = productOptional.get();
            if(product.getStock().isEmpty()) {
                productRepository.deleteById(id);
            } else {
                throw new Exception("Cannot delete product as it is associated with stock items.");
            }
        } else {
            throw new Exception("Product with id " + id + " not found.");
        }
    }

}
