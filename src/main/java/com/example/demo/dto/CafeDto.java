package com.example.demo.dto;

import com.example.demo.model.Cafe;
import com.example.demo.model.Food;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CafeDto {
    private String id;
    private String nameCafe;
    private String description;
    private java.util.List<Food> foods = new ArrayList<>();


    public static CafeDto from(Cafe cafe) {
        return builder()
                .id(cafe.getId())
                .nameCafe(cafe.getNameCafe())
                .foods((List<Food>) cafe.getFoods())
                .description(cafe.getDescription())
                .build();
    }
}
