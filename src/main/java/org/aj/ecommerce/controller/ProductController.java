package org.aj.ecommerce.controller;

import org.aj.ecommerce.model.Product;
import org.aj.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        System.out.println(products.get(0).getName() + " " + products.get(0).getPrice() + " " + products.get(0).getQuantity() + " " + products.get(0).getDescription());
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public Product getProductById(@PathVariable int productId) {
        return productService.getProductById(productId);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/product")
    public void deleteProduct(int productId) {
        productService.deleteProduct(productId);
    }
}
