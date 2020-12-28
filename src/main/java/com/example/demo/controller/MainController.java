package com.example.demo.controller;

import com.example.demo.domain.Order;
import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private OrderRepo orderRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(
            @AuthenticationPrincipal User user,
            Model model) {
        Iterable<Order> orders;

        if (user.getRoles().contains(Role.WORKER)) {
            orders = orderRepo.findAll();
        } else {
            orders = orderRepo.findByCustomer(user);
        }

        model.addAttribute("orders", orders);
        model.addAttribute("isAdmin", user.getRoles().contains(Role.ADMIN));

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            Map<String, Object> model
            ){
        Order order = new Order(text, user);

        orderRepo.save(order);

        Iterable<Order> orders = orderRepo.findAll();

        model.put("orders", orders);

        return "main";
    }
}