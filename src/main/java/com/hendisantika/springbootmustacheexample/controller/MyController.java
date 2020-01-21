package com.hendisantika.springbootmustacheexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mustache-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/01/20
 * Time: 06.02
 */
@Controller
@RequestMapping("/")
public class MyController {
    @GetMapping
    public String handleRequest(Model model) {
        model.addAttribute("todayCurrencyRates", getTodayForexRates());
        return "forex-view";
    }
}

