package com.example.IRCTC.Repository;

import com.example.IRCTC.Model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<FoodOrder, Integer> {

    List<FoodOrder> findByTrainId(int TrainId);
}
