package com.example.IRCTC.Controller;

import com.example.IRCTC.Model.Train;
import com.example.IRCTC.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    TrainService trainService;

    @PostMapping("/add")
    public ResponseEntity<String> addTrain(@RequestBody Train train){
        return trainService.addTrain(train);
    }
}
