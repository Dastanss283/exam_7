package com.example.demo.model;

import com.sun.tools.javac.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Document(collection = "order")
public class Order {
    @Id
    private String id = UUID.randomUUID().toString();
    private String orderedDish;
    private LocalDate date;
    @DBRef
    private List<Client> clientOrder;

}
