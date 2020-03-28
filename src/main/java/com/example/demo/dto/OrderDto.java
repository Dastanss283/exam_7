package com.example.demo.dto;
import com.example.demo.model.Cafe;
import com.example.demo.model.Client;
import com.example.demo.model.Order;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class OrderDto {
    String id;
    private Client clientOrder;
    private Cafe cafe;
    private LocalDateTime date;

    public static OrderDto from (Order orders) {
        return builder()
                .id(orders.getId())
                .clientOrder(orders.getClientOrder())
                .cafe(orders.getCafe())
                .date(orders.getDate())
                .build();
    }

}
