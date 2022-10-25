package com.epam.training.fooddelivery.service;

import com.epam.training.fooddelivery.domain.Food;
import com.epam.training.fooddelivery.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultFoodService implements FoodService {

    private FoodRepository foodRepository;

    @Autowired
    public DefaultFoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    @Transactional
    public List<Food> listAllFood() {
        return foodRepository.findAll();
    }
}
