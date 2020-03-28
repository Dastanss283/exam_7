package com.example.demo.model;

import com.example.demo.util.GenerateData;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "client")
@Builder
public class Client {
    @Id
    private String id = UUID.randomUUID().toString();
    @Indexed
    private String name;
    private String email;

    public static Client random() {
        return builder().name(GenerateData.randomPersonName())
        .email(GenerateData.randomEmail())
        .build();
    }
}
