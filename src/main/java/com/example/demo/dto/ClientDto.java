package com.example.demo.dto;

import com.example.demo.model.Client;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ClientDto {
    private String id;
    private String name;
    private String email;

    public static ClientDto from(Client client) {
        return builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .build();
    }

}
