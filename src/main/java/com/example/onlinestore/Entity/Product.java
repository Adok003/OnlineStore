package com.example.onlinestore.Entity;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    public Product() {
    }

    public Product(String name, String color, String size, int quantity, int price) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(Category category, String name, String color, String size, int quantity, int price) {
        this.category = category;
        this.name = name;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer product_id) {
        this.id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String product_name) {
        this.name = product_name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String product_color) {
        this.color = product_color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String product_size) {
        this.size = product_size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int product_quantity) {
        this.quantity = product_quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + id +
                ", category=" + category +
                ", product_name='" + name + '\'' +
                ", product_color='" + color + '\'' +
                ", product_size='" + size + '\'' +
                ", product_quantity=" + quantity + '\'' +
                ", price=" + price +
                '}';
    }
}

