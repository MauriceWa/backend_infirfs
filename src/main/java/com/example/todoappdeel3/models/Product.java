package com.example.todoappdeel3.models;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Number price;
    private String description;

    public Product() {
    }

    public Product(String name, String description, Number price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
