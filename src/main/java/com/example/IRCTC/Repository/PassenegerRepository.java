package com.example.IRCTC.Repository;

import com.example.IRCTC.Model.Gender;
import com.example.IRCTC.Model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PassenegerRepository extends JpaRepository<Passenger, Integer> {

    List<Passenger> findByDate(Date date);

    List<Passenger> findByGender(Gender gender);
}
