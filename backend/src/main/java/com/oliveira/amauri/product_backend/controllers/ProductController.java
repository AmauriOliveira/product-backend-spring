package com.oliveira.amauri.product_backend.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oliveira.amauri.product_backend.models.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin("http://127.0.0.1:5500")
public class ProductController {

  private List<Product> products =  new ArrayList<>();
  //@PostConstruct // chama após a construção, pode se decorar uma função

  @PostMapping("products")
  public ResponseEntity<Product>  save(@RequestBody Product product) {
      product.setId(products.size() +1);
      products.add(product);

      URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(product.getId())
        .toUri();

      return ResponseEntity.created(location).body(product);
  }

  @GetMapping("products/{id}")
  public ResponseEntity<Product> getProduct(@PathVariable int id) {
    return ResponseEntity.ok(
      this.products
      .stream()
      .filter(product -> product
      .getId() == id)
      .findFirst()
      .orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found.")
      )
    );
  }

  @GetMapping("products")
  public List<Product> getProducts() {
    return this.products;
  }
}
