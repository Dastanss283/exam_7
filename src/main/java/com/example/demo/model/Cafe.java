package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.UUID;

@Data
@Document(collection = "cafe")
public class Cafe {
    @Id
    private String id = UUID.randomUUID().toString();
    private String nameCafe;
    private String description;
    @DBRef
    private java.util.List<Food> foods=new ArrayList<>();


}
