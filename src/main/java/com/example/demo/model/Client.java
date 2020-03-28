package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "client")
public class Client {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String email;

}
