package com.ra.service.product;

import com.ra.model.dto.ProductDTO;
import com.ra.model.entity.Category;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();

    ProductDTO saveOrUpdate(ProductDTO productDTO);

    ProductDTO findById(Long id);

    void delete(Long id);
}
