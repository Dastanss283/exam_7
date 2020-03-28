package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "cafe")
@Builder
public class Cafe {
    @Id
    private String id = UUID.randomUUID().toString();
    private String nameCafe;
    private String description;
    @DBRef
    private List<Food> foods = new ArrayList<>();

    }

