package com.example.demo.repos;

import com.example.demo.domain.Order;
import com.example.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepo extends CrudRepository<Order, Long> {
    List<Order> findByCustomer(User customer);
}
