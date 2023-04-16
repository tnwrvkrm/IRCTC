package com.example.IRCTC.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticketId;

    private int trainId;
    private Date date;
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
