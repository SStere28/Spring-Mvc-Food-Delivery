package com.epam.training.fooddelivery.model;

import java.util.Objects;
import com.epam.training.fooddelivery.model.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FoodModel
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-03T11:49:52.498212400+03:00[Europe/Bucharest]")
public class FoodModel   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("calorie")
  private java.math.BigDecimal calorie = null;

  @JsonProperty("description")
  private String description;

  @JsonProperty("price")
  private java.math.BigDecimal price = null;

  @JsonProperty("category")
  private Category category;

  public FoodModel id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public FoodModel name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FoodModel calorie(java.math.BigDecimal calorie) {
    this.calorie = calorie;
    return this;
  }

  /**
   * Get calorie
   * @return calorie
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public java.math.BigDecimal getCalorie() {
    return calorie;
  }

  public void setCalorie(java.math.BigDecimal calorie) {
    this.calorie = calorie;
  }

  public FoodModel description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public FoodModel price(java.math.BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public java.math.BigDecimal getPrice() {
    return price;
  }

  public void setPrice(java.math.BigDecimal price) {
    this.price = price;
  }

  public FoodModel category(Category category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FoodModel foodModel = (FoodModel) o;
    return Objects.equals(this.id, foodModel.id) &&
        Objects.equals(this.name, foodModel.name) &&
        Objects.equals(this.calorie, foodModel.calorie) &&
        Objects.equals(this.description, foodModel.description) &&
        Objects.equals(this.price, foodModel.price) &&
        Objects.equals(this.category, foodModel.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, calorie, description, price, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FoodModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    calorie: ").append(toIndentedString(calorie)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

