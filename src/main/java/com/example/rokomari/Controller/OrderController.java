package com.example.rokomari.Controller;

import com.example.rokomari.DTO.UserDto;
import com.example.rokomari.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rokomari")
public class OrderController {
    @Autowired
    OrderService orderService;

// url = localhost:8070/rokomari/user/orders?id=2
    @GetMapping("/user/orders")
    public UserDto getOrderDetails(@RequestParam("id") Long id) {
        return orderService.userOrderDetails(id);
    }
}
