package com.example.demo.entities;

import jakarta.persistence.*;



/* This class if for converting the data from database into Product objects */

@Entity
@Table(name = "Product")
public class ProductEntity {

    @Id
    @Column(name = "p_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private float price;

    @Column
    private int count;

    @Column
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @ManyToOne
    @JoinColumn(name = "sellerId",referencedColumnName = "id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "categoryId",referencedColumnName = "id")
    private CategoryEntity category;

    public ProductEntity() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public ProductEntity(int id, String name, String description, float price, int count, String image,UserEntity userEntity, CategoryEntity category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = count;
        this.userEntity = userEntity;
        this.category = category;
        this.image=image;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", image='" + image + '\'' +
                ", userEntity=" + userEntity +
                ", category=" + category +
                '}';
    }
}
