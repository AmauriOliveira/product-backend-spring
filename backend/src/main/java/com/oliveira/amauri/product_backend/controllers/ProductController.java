package com.oliveira.amauri.product_backend.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.oliveira.amauri.product_backend.models.Product;

@RestController
public class ProductController {

  private List<Product> products = Arrays.asList(
    new Product(1, "Doce", 0.5),
    new Product(2, "Pipoca", 0.7),
    new Product(3, "Hot Dog", 6.5)
  );

  //@PostConstruct // chama após a construção, pode se decorar uma função

  @GetMapping("products/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable int id) {
    return ResponseEntity.ok(
      this.products.stream()
      .filter(product -> product
      .getId() == id).findFirst()
      .orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "product not found.")
      )
    );
  }

  @GetMapping("products")
  public List<Product> getProducts() {
    return this.products;
  }
}
