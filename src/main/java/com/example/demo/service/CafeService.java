package com.example.demo.service;
import com.example.demo.dto.CafeDto;
import com.example.demo.exeptions.ResourceNotFoundException;
import com.example.demo.model.Cafe;
import com.example.demo.repository.CafeRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeService {
    @Autowired
    static CafeRepository cafeRepository;

    public CafeDto add(CafeDto cafeDto) {
        var dishes = Cafe.builder()
                .nameCafe(cafeDto.getNameCafe())
                .description(cafeDto.getDescription())
                .foods(cafeDto.getFoods())
                .build();

        return CafeDto.from(dishes);
    }
    public static CafeDto find (String cafeId) {
        var cafe = cafeRepository.findById(cafeId)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find food with the ID: " + cafeId));
        return CafeDto.from((Cafe) cafe);

    }
}
