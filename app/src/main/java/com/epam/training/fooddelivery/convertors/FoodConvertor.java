package com.epam.training.fooddelivery.convertors;

import com.epam.training.fooddelivery.domain.Food;
import com.epam.training.fooddelivery.model.Category;
import com.epam.training.fooddelivery.model.FoodModel;

import java.util.ArrayList;
import java.util.List;

public class FoodConvertor {

    public List<FoodModel> convertList(List<Food> foods) {

        List<FoodModel> foodModels = new ArrayList<>();
        for (Food food : foods
        ) {
            FoodModel foodModel = new FoodModel();
            foodModel.setCalorie(food.getCalorie());
            foodModel.setCategory(Category.valueOf(food.getCategory().toString()));
            foodModel.setDescription(food.getDescription());
            foodModel.setId(food.getId());
            foodModel.setPrice(food.getPrice());
            foodModel.setName(food.getName());
            foodModels.add(foodModel);
        }
        return foodModels;
    }

    public FoodModel convertFood(Food food) {
        FoodModel foodModel = new FoodModel();
        foodModel.setCalorie(food.getCalorie());
        foodModel.setCategory(Category.valueOf(food.getCategory().toString()));
        foodModel.setDescription(food.getDescription());
        foodModel.setId(food.getId());
        foodModel.setPrice(food.getPrice());
        foodModel.setName(food.getName());
        return foodModel;
    }
}
