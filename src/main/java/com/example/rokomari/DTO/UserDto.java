package com.example.rokomari.DTO;

import com.example.rokomari.Entities.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String username;
    private String gender;
    private String mobileNumber;
    private int orders;
    private List<OrderDto> orderList = new ArrayList<>();
}
