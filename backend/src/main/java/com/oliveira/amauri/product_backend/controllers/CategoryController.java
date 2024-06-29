package com.oliveira.amauri.product_backend.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.oliveira.amauri.product_backend.models.Category;


@RestController
public class CategoryController {

  private List<Category> categories = Arrays.asList(
    new Category(1, "Produção Propria"),
    new Category(2, "Nacional"),
    new Category(3, "Importado")
  );

  @GetMapping("categories/{id}")
  public ResponseEntity<Category> getCategory(@PathVariable int id) {
    return ResponseEntity.ok(
      this.categories
      .stream().
      filter(category -> category
      .getId() == id)
      .findFirst()
      .orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found.")
      )
    );
  }

  @GetMapping("categories")
  public List<Category> getCategories() {
      return this.categories;
  }
}
