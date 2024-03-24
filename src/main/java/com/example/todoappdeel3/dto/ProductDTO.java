package com.example.todoappdeel3.dto;

public class ProductDTO {
    public String name;
    public String description;
    public Number price;

    public ProductDTO(String name, String description, Number price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
