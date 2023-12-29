package com.ra.controller;

import com.ra.model.dto.ProductDTO;
import com.ra.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<ProductDTO> productDTOList = productService.findAll();
        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO newproductDTO = productService.saveOrUpdate(productDTO);
        return new ResponseEntity<>(newproductDTO, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductDTO> deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Long id) {
        ProductDTO productDTO = productService.findById(id);
        if (productDTO != null) {
            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> editProduct(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
        ProductDTO productDTO1 = productService.findById(id);
        productDTO1.setId(productDTO.getId());
        productDTO1.setProductName(productDTO.getProductName());
        productDTO1.setStatus(productDTO.isStatus());
        productDTO1.setCategoryId(productDTO.getCategoryId());
        productService.saveOrUpdate(productDTO1);
        return new ResponseEntity<>(productService.saveOrUpdate(productDTO1), HttpStatus.OK);
    }
}
