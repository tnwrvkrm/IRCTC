package com.example.IRCTC.Service;

import com.example.IRCTC.Model.Train;
import com.example.IRCTC.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TrainService {

    @Autowired
    TrainRepository trainRepository;

    public ResponseEntity<String> addTrain(Train train){
        trainRepository.save(train);

        return new ResponseEntity<>("Train added", HttpStatus.CREATED);
    }


}
