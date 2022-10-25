package com.epam.training.fooddelivery.model;

import java.util.Objects;
import com.epam.training.fooddelivery.model.OrderItemModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderModel
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-03T11:49:52.498212400+03:00[Europe/Bucharest]")
public class OrderModel   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("price")
  private java.math.BigDecimal price = null;

  @JsonProperty("timestampCreated")
  private java.util.Date timestampCreated = null;

  @JsonProperty("orderItemModels")
  @Valid
  private List<OrderItemModel> orderItemModels = new ArrayList<>();

  public OrderModel id(Long id) {
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

  public OrderModel price(java.math.BigDecimal price) {
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

  public OrderModel timestampCreated(java.util.Date timestampCreated) {
    this.timestampCreated = timestampCreated;
    return this;
  }

  /**
   * Get timestampCreated
   * @return timestampCreated
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public java.util.Date getTimestampCreated() {
    return timestampCreated;
  }

  public void setTimestampCreated(java.util.Date timestampCreated) {
    this.timestampCreated = timestampCreated;
  }

  public OrderModel orderItemModels(List<OrderItemModel> orderItemModels) {
    this.orderItemModels = orderItemModels;
    return this;
  }

  public OrderModel addOrderItemModelsItem(OrderItemModel orderItemModelsItem) {
    this.orderItemModels.add(orderItemModelsItem);
    return this;
  }

  /**
   * Get orderItemModels
   * @return orderItemModels
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<OrderItemModel> getOrderItemModels() {
    return orderItemModels;
  }

  public void setOrderItemModels(List<OrderItemModel> orderItemModels) {
    this.orderItemModels = orderItemModels;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderModel orderModel = (OrderModel) o;
    return Objects.equals(this.id, orderModel.id) &&
        Objects.equals(this.price, orderModel.price) &&
        Objects.equals(this.timestampCreated, orderModel.timestampCreated) &&
        Objects.equals(this.orderItemModels, orderModel.orderItemModels);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, price, timestampCreated, orderItemModels);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderModel {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    timestampCreated: ").append(toIndentedString(timestampCreated)).append("\n");
    sb.append("    orderItemModels: ").append(toIndentedString(orderItemModels)).append("\n");
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

