package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Food {
    @Id
    private String id;
    private int price;
    private String nameOfFood;
    private String typeOfFood;



}
