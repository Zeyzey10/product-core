package sn.isi.l3gl.core.service;

import org.springframework.stereotype.Service;
import sn.isi.l3gl.core.entity.Product;
import sn.isi.l3gl.core.repository.ProductRepository;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // v0.0.1
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // v0.1.0
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    // v0.2.0
    public Product updateQuantity(Long id, Integer newQuantity) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found: " + id));
        product.setQuantity(newQuantity);
        return productRepository.save(product);
    }

    // v0.3.0
    public long countLowStockProducts() {
        return productRepository.countByQuantityLessThanEqual(5);
    }
}