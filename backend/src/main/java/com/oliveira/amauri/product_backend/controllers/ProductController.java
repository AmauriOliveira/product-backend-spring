package com.oliveira.amauri.product_backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oliveira.amauri.product_backend.models.Product;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProductController {

  @GetMapping("product")
  public Product getProduct() {
    return new Product(1, "Doce", 0.5);
  }

  @SuppressWarnings("unchecked")
  @GetMapping("products")
  public List<Product> getProducts() {
    Product product1 = new Product(1, "Doce", 0.5);
    Product product2 = new Product(2, "Pipoca", 0.7);
    Product product3 = new Product(3, "Hot Dog", 6.5);

    List productList = new ArrayList<Product>();

    productList.add(product1);
    productList.add(product2);
    productList.add(product3);

    return productList;
  }
}
