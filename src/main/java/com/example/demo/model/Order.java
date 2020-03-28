package com.example.demo.model;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document(collection = "order")
@Builder
public class Order {
    @Id
    private String id = UUID.randomUUID().toString();
    @DBRef
    private Client clientOrder;
    @DBRef
    private Cafe cafe;
    private LocalDateTime date;

    public static Order random(Client client, Cafe cafe) {
        return builder()
                .clientOrder(client)
                .cafe(cafe)
                .date(LocalDateTime.now())
                .build();
    }
}

