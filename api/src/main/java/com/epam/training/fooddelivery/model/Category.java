package com.epam.training.fooddelivery.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets Category
 */
public enum Category {
  
  GRAINS("GRAINS"),
  
  FRUIT("FRUIT"),
  
  VEGETABLE("VEGETABLE"),
  
  DAIRY("DAIRY"),
  
  MEAT("MEAT"),
  
  SNACK("SNACK"),
  
  MEAL("MEAL");

  private String value;

  Category(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Category fromValue(String value) {
    for (Category b : Category.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

