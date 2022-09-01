package com.github.erf88;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class CalcController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/calc/{num1}/{num2}/{operator}")
    public String calc(@PathVariable Double num1, @PathVariable Double num2, @PathVariable String operator) {

        final String url = "http://spring-cloud-eureka-client-1";

        switch (operator) {
            case "+":
                String sumUrl = url + "/sum/{num1}/{num2}";
                return restTemplate.getForObject(sumUrl, String.class, num1, num2);
            case "-":
                String subtractUrl = url + "/subtract/{num1}/{num2}";
                return restTemplate.getForObject(subtractUrl, String.class, num1, num2);
            default:
                return "Invalid operator!";
        }

    }
}
