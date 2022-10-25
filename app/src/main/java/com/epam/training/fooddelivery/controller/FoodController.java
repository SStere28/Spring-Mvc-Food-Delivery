package com.epam.training.fooddelivery.controller;

import com.epam.training.fooddelivery.convertors.FoodConvertor;
import com.epam.training.fooddelivery.model.FoodModel;
import com.epam.training.fooddelivery.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;


    @RequestMapping(value = "/foodService/foods", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> listAllFoods(HttpServletResponse httpServletResponse) {

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if(authentication == null || !authentication.isAuthenticated() ){
//            //  httpServletResponse.setStatus(403);
//            return ResponseEntity.status(403).build();
//        }
        FoodConvertor foodConvertor = new FoodConvertor();
        return   new ResponseEntity<>( foodConvertor.convertList(foodService.listAllFood()), HttpStatus.OK); }
}
