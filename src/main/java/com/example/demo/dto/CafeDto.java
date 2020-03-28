package com.example.demo.dto;

import com.example.demo.model.Cafe;
import com.example.demo.model.Food;
import com.sun.tools.javac.util.List;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CafeDto {
    String id;
    String nameCafe;
    String description;
    List<Food> foods;

    public static CafeDto from(Cafe cafe) {
        return builder()
                .id(cafe.getId())
                .nameCafe(cafe.getNameCafe())
                .foods((List<Food>) cafe.getFoods())
                .description(cafe.getDescription())
                .build();
    }
}
