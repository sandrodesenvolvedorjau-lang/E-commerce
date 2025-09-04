package br.kodemaster.dscommerce.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_products")
public class Product extends BaseEntity {
    // Attributes
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
    private double price;
    private String imgUrl;

    // Relationships
    @ManyToMany
    @JoinTable(
            name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_uuid", referencedColumnName = "uuid"),
            inverseJoinColumns = @JoinColumn(name = "category_uuid", referencedColumnName = "uuid")
    )
    private final Set<Category> categories = new HashSet<>();

    // Constructors
    public Product(){}

    public Product(String name, String description, double price, String imgUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }
}
