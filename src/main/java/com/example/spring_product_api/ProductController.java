/**
 * Created by mupezeni for spring_product_api
 * User: mupezeni
 * Date: 10/9/2022
 * Time: 14:11
 */


package com.example.spring_product_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> list() {
        return productService.listAll();
    }


    @GetMapping("/product/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        try {
            Product product = productService.getProduct(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/addproduct")
    public void add(@RequestBody Product product) {
        productService.save(product);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id) {
        try {
            Product existProduct = productService.getProduct(id);
            productService.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

}
