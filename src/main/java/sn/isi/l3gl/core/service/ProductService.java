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

    // v0.0.1-SNAPSHOT
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // v0.1.0-SNAPSHOT
    public List<Product> listProducts() {
        return productRepository.findAll();
    }
}