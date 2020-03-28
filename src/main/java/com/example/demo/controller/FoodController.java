package com.example.demo.controller;

import com.example.demo.annotations.ApiPageable;
import com.example.demo.dto.FoodDto;
import com.example.demo.service.FoodService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
@RestController
@RequestMapping("/foods")
public class FoodController {
    FoodService foodService;

    @ApiPageable
    @GetMapping
    public Slice<FoodDto> findFoods(@ApiIgnore Pageable pageable) {
        return foodService.findFoods(pageable);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public FoodDto addFood(@RequestBody FoodDto foodDto) {
        return foodService.add(foodDto);
    }
    @GetMapping("/{clientId}")
    public FoodDto getFood(@PathVariable String foodId) {
        return foodService.find(foodId);
    }
}



