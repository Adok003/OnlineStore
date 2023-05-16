package com.example.onlinestore.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "image", length = Integer.MAX_VALUE)
    private byte[] image;

    @Column(name = "imgName")
    private String imgName;

    @Column(name = "type")
    private String type;

    public Category() {
    }

    public Category(String name, byte[] image) {
        this.name = name;
        this.image = image;
    }

    public Category(String name, byte[] image, String imgName, String type) {
        this.name = name;
        this.image = image;
        this.imgName = imgName;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String category_name) {
        this.name = category_name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String fileName) {
        this.imgName = fileName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                ", imgName='" + imgName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

