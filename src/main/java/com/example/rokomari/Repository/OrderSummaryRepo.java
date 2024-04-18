package com.example.rokomari.Repository;

import com.example.rokomari.Entities.OrderSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSummaryRepo extends JpaRepository<OrderSummary,Long>{
}
