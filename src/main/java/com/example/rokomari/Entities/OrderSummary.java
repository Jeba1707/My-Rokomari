package com.example.rokomari.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter

public class OrderSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @MapsId
    @OneToOne
    private Order order;
    private int totalItems;
    private long subtotal;
    private long afterDiscount;
    private int shipping;


    public OrderSummary(Order order) {
        setOrder(order);
        setOrderId();
        setTotalItems();
        setSubtotal();
        setAfterDiscount();
    }


    public void setOrderId() {
        this.orderId =order.getOrderId();
    }

//    public void setOrder(Order order) {
//        this.order = order;
//    }

    public void setTotalItems() {
        this.totalItems = order.getBooks().size();
    }

    public void setSubtotal() {
        long sum = 0;
        for(Book book: order.getBooks()){
           sum=sum+ book.getPrice();
        }
        this.subtotal = sum;
    }

    public void setAfterDiscount() {
        long sum = 0;
        for(Book book: order.getBooks()){
            sum=sum+ book.getDiscount();
        }
        this.afterDiscount = getSubtotal()-sum;
    }

//    public void setShipping(int shipping) {
//        this.shipping = shipping;
//    }
}
