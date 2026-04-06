package com.telusko.springecom.service;

import com.telusko.springecom.model.Product;
import com.telusko.springecom.repo.ProductRepo;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Transactional
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Transactional
    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(new Product(-1));
    }

    @Transactional
    public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {

        if(image!=null && !image.isEmpty()) {
            product.setImageName(image.getOriginalFilename());
            product.setImageType(image.getContentType());
            product.setImageData(image.getBytes());
        }

        return productRepo.save(product);
    }

    @Transactional
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    @Transactional
    public List<Product> searchProducts(String keyword) {
        return productRepo.searchProducts(keyword);
    }
}
