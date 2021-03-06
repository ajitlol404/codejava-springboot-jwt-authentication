package com.springjwt.product.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductApiController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping
    @RolesAllowed({"ROLE_CUSTOMER","ROLE_EDITOR"})
    public List<Product> list() {
        return productRepository.findAll();
    }

    @PostMapping
    @RolesAllowed("ROLE_EDITOR")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product) {
        Product savedProduct = productRepository.save(product);
        URI productUri = URI.create("/products/" + savedProduct.getId());

        return ResponseEntity.created(productUri).body(savedProduct);
    }

}
