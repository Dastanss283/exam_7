package com.example.demo.model;

import com.sun.tools.javac.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cafe")
public class Cafe {
    @Id
    private String id;
    private String title;
    private String subscription;
    private String dish;
    @DBRef
    private List<Client> clientList;

}
