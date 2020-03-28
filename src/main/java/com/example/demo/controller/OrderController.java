package com.example.demo.controller;

import com.example.demo.annotations.ApiPageable;
import com.example.demo.dto.OrderDto;
import com.example.demo.service.OderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OderService orderService;
    @ApiPageable
    @GetMapping
    public Slice<OrderDto> findOrders(@ApiIgnore Pageable pageable){
        return orderService.find(pageable);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto addClient(@RequestBody OrderDto orderDto) {
        return orderService.add(orderDto);
    }
    @GetMapping("/{orderId}")
    public OrderDto getOrder(@PathVariable String orderId) {
        return orderService.findOne(orderId);
    }
}