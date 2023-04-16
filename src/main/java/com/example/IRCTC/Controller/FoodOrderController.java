package com.example.IRCTC.Controller;

import com.example.IRCTC.Service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/FoodOrder")
public class FoodOrderController {

    @Autowired
    FoodOrderService foodOrderService;

    @GetMapping("/GetTotalPrice")
    public int getTotalPrice(@RequestParam Date date,@RequestParam int trainId){
        return foodOrderService.getTotalPrice(date, trainId);
    }
}
