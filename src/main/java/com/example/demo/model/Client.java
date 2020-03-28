package com.example.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "client")
public class Client {
    @Id
    private String id;
    private String name;
    private String email;

}
