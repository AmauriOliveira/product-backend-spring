package com.oliveira.amauri.product_backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  /**
   * @return Hello World
   */
  @GetMapping("")
  public String getHello() {
    return "Hello World";
  }
}
