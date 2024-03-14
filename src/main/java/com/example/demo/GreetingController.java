package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.DatabaseConnection.*;


@RestController
public class GreetingController {


    DatabaseConnection connection = new DatabaseConnection("jdbc:mysql://localhost:3306/database_1", "root", "1234");

    private int user_id = connection.getUserId();
    private String first_name = connection.getFirstName();
    private String last_name = connection.getLastName();

    @GetMapping("/greeting")
    public Greeting greeting() {
        return new Greeting(user_id, String.format(first_name), last_name);
    }
}