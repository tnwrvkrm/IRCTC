package com.example.IRCTC.Controller;

import com.example.IRCTC.Model.Passenger;
import com.example.IRCTC.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.Date;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @PostMapping("/add")
    public ResponseEntity<String> addPassenger(@RequestBody Passenger passenger){
        return passengerService.addPassenger(passenger);
    }

    @GetMapping("/noOfPassengerFromXToY")
    public int noOfPassengerFromXToY(@RequestParam String x, @RequestParam String y, @RequestParam Date date){
        return passengerService.findPassengerFromXToY(x, y, date);
    }

    @GetMapping("/findFemaleBWAge")
    public int findFemalePBWAge(@RequestParam int x,@RequestParam int y,@RequestParam String destination){
        return passengerService.findFemalePBWAge(x, y, destination);
    }
}
