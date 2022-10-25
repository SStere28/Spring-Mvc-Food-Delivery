package com.epam.training.fooddelivery.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
@Entity
public class Food {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private BigDecimal calorie;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column
    private BigDecimal price;
    @Column
    private String description;



    public Food() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCalorie() {
        return calorie;
    }

    public void setCalorie(BigDecimal calorie) {
        this.calorie = calorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Food)) return false;
        Food food = (Food) o;
        return getId() == food.getId() && Objects.equals(getName(), food.getName()) && Objects.equals(getCalorie(), food.getCalorie()) && Objects.equals(getDescription(), food.getDescription()) && Objects.equals(getPrice(), food.getPrice()) && getCategory() == food.getCategory();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCalorie(), getDescription(), getPrice(), getCategory());
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calorie=" + calorie +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
