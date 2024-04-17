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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String gender;
    private String mobileNumber;
    @OneToMany(mappedBy ="user" ,cascade = CascadeType.ALL)
    private List<Order> orderList = new ArrayList<Order>();

}
