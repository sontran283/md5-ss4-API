package com.ra.service.product;

import com.ra.model.dto.ProductDTO;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.repository.ProductRepository;
import com.ra.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;

    @Override
    public List<ProductDTO> findAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setProductName(product.getProductName());
            productDTO.setStatus(product.isStatus());
            productDTO.setCategoryId(product.getCategory().getId());
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public ProductDTO saveOrUpdate(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setProductName(productDTO.getProductName());
        product.setStatus(productDTO.isStatus());
        Category category = categoryService.findById(productDTO.getCategoryId());
        product.setCategory(category);

        product = productRepository.save(product);
        ProductDTO productDTO1 = new ProductDTO();
        productDTO1.setId(product.getId());
        productDTO1.setProductName(product.getProductName());
        productDTO1.setStatus(product.isStatus());
        productDTO1.setCategoryId(product.getCategory().getId());
        return productDTO1;
    }

    @Override
    public ProductDTO findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product product1 = product.get();
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product1.getId());
            productDTO.setProductName(product1.getProductName());
            productDTO.setStatus(product1.isStatus());
            productDTO.setCategoryId(product1.getCategory().getId());
            return productDTO;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
