package com.github.erf88;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SumController {

    @GetMapping("/sum/{num1}/{num2}")
    public String sum(@PathVariable Double num1, @PathVariable Double num2) {
        double result = num1 + num2;
        return "Result: " + result;
    }

    @GetMapping("/subtract/{num1}/{num2}")
    public String subtract(@PathVariable Double num1, @PathVariable Double num2) {
        double result = num1 - num2;
        return "Result: " + result;
    }

}
