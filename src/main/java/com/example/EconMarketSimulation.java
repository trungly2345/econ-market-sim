package com.example;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;


@RestController 
@EnableAutoConfiguration
public class EconMarketSimulation {
      



        @RequestMapping("/")
        String home(){
                return "Econ Market Simulator";
        }

    public static void main(String[] args) {
        SpringApplication.run(EconMarketSimulation.class, args);
    }
}

    