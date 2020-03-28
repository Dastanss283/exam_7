package com.example.demo.service;

import com.example.demo.dto.FoodDto;
import com.example.demo.exeptions.ResourceNotFoundException;
import com.example.demo.model.Food;
import com.example.demo.repository.FoodRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Autowired
    FoodRepository foodRepository;

    public FoodDto add (FoodDto foodDto) {
        var food = Food.builder()
                .nameOfFood(foodDto.getName())
                .typeOfFood(foodDto.getType())
                .price(foodDto.getPrice())
                .build();

        foodRepository.save(food);
        return FoodDto.from(food);
    }

    public Slice<FoodDto> findFoods(Pageable pageable) {
        var slice = foodRepository.findAll(pageable);
        return slice.map(FoodDto::from);
    }
    public FoodDto find (String clientId) {
        var movie = foodRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find food with the ID: " + clientId));
        return FoodDto.from(movie);
    }



}