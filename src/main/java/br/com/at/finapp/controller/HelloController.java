package br.com.at.finapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    public ResponseEntity<String> HelloWorld(){
        return ResponseEntity.status(201).body("Hello World. One More to the counter");
    }

}
