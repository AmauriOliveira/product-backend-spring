package com.oliveira.amauri.product_backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.oliveira.amauri.product_backend.models.Product;

import jakarta.annotation.PostConstruct;

@RestController
public class ProductController {

  private List<Product> products = new ArrayList<>();

  @PostConstruct // chama após a construção
  public void init() {
    Product product1 = new Product(1, "Doce", 0.5);
    Product product2 = new Product(2, "Pipoca", 0.7);
    Product product3 = new Product(3, "Hot Dog", 6.5);

    this.products.add(product1);
    this.products.add(product2);
    this.products.add(product3);
  }

  @GetMapping("products/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable int id) {
    Product result = null;
    for (Product product: this.products) {

      if (product.getId() == id) {
        result = product;

        break;
      }
    }
    if (result == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "product not found.");
    } else {
      return ResponseEntity.ok(result);
    }
  }

  @GetMapping("products")
  public List<Product> getProducts() {
    return this.products;
  }
}
