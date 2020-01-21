package com.hendisantika.springbootmustacheexample.controller;

import com.hendisantika.springbootmustacheexample.domain.CurrencyRate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

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

    private List<CurrencyRate> getTodayForexRates() {
        //dummy rates
        List<CurrencyRate> currencyRates = new ArrayList<>();
        LocalDateTime today = LocalDateTime.now();
        List<Currency> currencies = new ArrayList<>(Currency.getAvailableCurrencies());

        for (int i = 0; i < currencies.size(); i += 2) {
            String currencyPair = currencies.get(i) + "/" + currencies.get(i + 1);
            CurrencyRate cr = new CurrencyRate();
            cr.setCurrencyPair(currencyPair);
            cr.setDateTime(today);
            BigDecimal bidPrice = new BigDecimal(Math.random() * 5 + 1);
            bidPrice = bidPrice.setScale(3, RoundingMode.CEILING);
            cr.setBidPrice(bidPrice);
            BigDecimal askPrice = new BigDecimal(bidPrice.doubleValue() + Math.random() * 2 + 0.5);
            askPrice = askPrice.setScale(3, RoundingMode.CEILING);
            cr.setAskPrice(askPrice);
            currencyRates.add(cr);
        }
        return currencyRates;
    }
}

