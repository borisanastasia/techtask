package com.example.techtask.repository;

import com.example.techtask.model.User;
import com.example.techtask.model.enumiration.OrderStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, Integer> {

    @Query("""
            SELECT u FROM User u JOIN u.orders o
            WHERE CAST(o.orderStatus as String) = :#{#orderStatus.name()} AND year(o.createdAt) = :orderYear
            GROUP BY u.id
            ORDER BY SUM(o.price * o.quantity) DESC
            LIMIT 1
            """)
    User findByMaxTotalCostAndOrderStatusAndOrderYear(OrderStatus orderStatus, int orderYear);

    @Query("""
            SELECT u FROM User u JOIN u.orders o
            WHERE CAST(o.orderStatus as String) = :#{#orderStatus.name()} AND year(o.createdAt) = :orderYear
            """)
    List<User> findByOrderStatusAndOrderYear(OrderStatus orderStatus, int orderYear);
}
