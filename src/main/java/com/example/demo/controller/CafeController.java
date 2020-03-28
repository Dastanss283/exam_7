package com.example.demo.controller;

import com.example.demo.dto.CafeDto;
import com.example.demo.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cafes")
public class CafeController {
    @Autowired
    CafeService cafeService;
    @GetMapping("/{cafeId}")
    public CafeDto getCafe(@PathVariable String cafeId) {
        return cafeService.find(cafeId);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CafeDto addCafe(@RequestBody CafeDto cafeDto) {
        return cafeService.add(cafeDto);
    }
}