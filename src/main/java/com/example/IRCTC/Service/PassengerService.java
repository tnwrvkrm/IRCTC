package com.example.IRCTC.Service;

import com.example.IRCTC.Model.Gender;
import com.example.IRCTC.Model.Passenger;
import com.example.IRCTC.Model.Train;
import com.example.IRCTC.Repository.PassenegerRepository;
import com.example.IRCTC.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PassengerService {
    @Autowired
    PassenegerRepository passenegerRepository;

    @Autowired
    TrainRepository trainRepository;

    public ResponseEntity<String> addPassenger(Passenger passenger){

        //if given train doesn't exist
        if(!trainRepository.existsById(passenger.getTrainId()))
            return new ResponseEntity<>("Invalid given ID", HttpStatus.NOT_FOUND);


        passenegerRepository.save(passenger);

        return new ResponseEntity<>("Passenger added", HttpStatus.CREATED);
    }

    public int findPassengerFromXToY(String x, String y, Date date){
        List<Passenger> passengerListOnDate = passenegerRepository.findByDate(date);

        int noOfPassenger = 0;

        for(Passenger p : passengerListOnDate){
            Train train = trainRepository.findById(p.getTrainId()).get();

            if(train.getSource().equals(x) && train.getDestination().equals(y))
                noOfPassenger++;
        }

        return noOfPassenger;
    }

    public int findFemalePBWAge(int x, int y, String destination){
        int totalCountOfRequiredFemale = 0;

        List<Passenger> femalePassengerList= passenegerRepository.findByGender(Gender.Female);

        for (Passenger p: femalePassengerList){
            if(p.getAge() >= x && p.getAge() < y){
                Train train = trainRepository.findById(p.getTrainId()).get();
                if(train.getDestination().equals(destination))
                    totalCountOfRequiredFemale++;
            }
        }

        return totalCountOfRequiredFemale;
    }
}
