package com.ra.model.dto;


public class ProductDTO {
    private Long id;

    private String productName;

    private boolean status;

    private Long categoryId;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String productName, boolean status, Long categoryId) {
        this.id = id;
        this.productName = productName;
        this.status = status;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
