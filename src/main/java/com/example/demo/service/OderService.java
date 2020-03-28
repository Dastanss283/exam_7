package com.example.demo.service;

import com.example.demo.dto.OrderDto;
import com.example.demo.exeptions.ResourceNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class OderService {
    @Autowired
    OrderRepository orderRepository;

    public OrderDto add (OrderDto orderDto){
        var order= Order.builder()
                .clientOrder(orderDto.getClientOrder())
                .cafe(orderDto.getCafe())
                .date(orderDto.getDate())
                .build();
        orderRepository.save(order);
        return OrderDto.from(order);

    }

    public Slice<OrderDto> find (Pageable pageable) {
        var slice = orderRepository.findAll(pageable);
        return slice.map(OrderDto::from);
    }
    public OrderDto findOne(String clientId) {
        var movie = orderRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find order with the ID: " + clientId));
        return OrderDto.from(movie);
    }


}
