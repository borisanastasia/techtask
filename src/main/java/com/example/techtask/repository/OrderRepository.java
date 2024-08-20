package com.example.techtask.repository;

import com.example.techtask.model.Order;
import com.example.techtask.model.enumiration.UserStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface OrderRepository extends Repository<Order, Integer> {

    Order findFirstByQuantityGreaterThanOrderByCreatedAtDesc(int quantity);

    @Query("""
            SELECT o FROM User u JOIN u.orders o
            WHERE CAST(u.userStatus as String) = :#{#userStatus.name()}
            ORDER BY o.createdAt
            """)
    List<Order> findByUserStatusOrderByCreatedAt(UserStatus userStatus);
}
