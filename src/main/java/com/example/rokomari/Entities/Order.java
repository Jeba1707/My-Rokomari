package com.example.rokomari.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String orderDate;
    @ManyToMany(mappedBy = "orders" ,cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
