package com.example.techtask.service.impl;

import com.example.techtask.model.User;
import com.example.techtask.repository.UserRepository;
import com.example.techtask.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.techtask.model.enumiration.OrderStatus.DELIVERED;
import static com.example.techtask.model.enumiration.OrderStatus.PAID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findUser() {
        return userRepository.findByMaxTotalCostAndOrderStatusAndOrderYear(DELIVERED, 2003);
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findByOrderStatusAndOrderYear(PAID, 2010);
    }
}
