package com.example.rokomari.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private String date;
    private int quantity;
    private List<BookDto> books = new ArrayList<BookDto>();
    private OrderSummaryDto orderSummary;

}
