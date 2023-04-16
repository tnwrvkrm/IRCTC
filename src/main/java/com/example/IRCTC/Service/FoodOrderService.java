package com.example.IRCTC.Service;

import com.example.IRCTC.Model.FoodOrder;
import com.example.IRCTC.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FoodOrderService {

    @Autowired
    FoodRepository foodRepository;

    public int getTotalPrice(Date date, int trainId){
        List<FoodOrder> foodOrderList = foodRepository.findByTrainId(trainId);

        int totalPrice = 0;

        for(FoodOrder foodOrder : foodOrderList){
            totalPrice += foodOrder.getPrice();
        }

        return totalPrice;
    }
}
