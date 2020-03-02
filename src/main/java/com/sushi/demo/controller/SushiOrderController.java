package com.sushi.demo.controller;

import com.sushi.demo.dao.StatusRepo;
import com.sushi.demo.dao.SushiOrderRepo;
import com.sushi.demo.model.*;
import com.sushi.demo.dao.SushiRepo;
import com.sushi.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

import static java.time.LocalTime.now;


@RestController
public class SushiOrderController {

    private SushiRepo sushiRepo;

    private SushiOrderRepo sushiOrderRepo;

    private StatusRepo statusRepo;

    @Autowired public SushiOrderController(SushiRepo sushiRepo, SushiOrderRepo sushiOrderRepo, StatusRepo statusRepo){
        this.sushiRepo = sushiRepo;
        this.sushiOrderRepo = sushiOrderRepo;
        this.statusRepo = statusRepo;
    }

    @PostMapping(path="/api/orders",consumes= {"application/json"})
    public SushiOrderCreateResp setOrder(@RequestBody SushiOrderCreateRequest sushiOrderCreateRequest)
    {
        Optional<Sushi> sushi= sushiRepo.findByName(sushiOrderCreateRequest.getSushi_name());
        SushiOrder sushiOrder = new SushiOrder();
        SushiOrderCreateResp result = new SushiOrderCreateResp();
        SushiOrder orderInfo = new SushiOrder();
        if(sushi.isPresent()){
            sushiOrder.setSushiId(sushi.get().getId());
            sushiOrder.setStatusId(1);
            LocalDateTime now = LocalDateTime.now();
            sushiOrder.setCreatedAt(Timestamp.valueOf(now));
            orderInfo =sushiOrderRepo.save(sushiOrder);
        }
        result.setCode("0");
        result.setMsg("Order submitted");
        result.setSushiOrder(orderInfo);
        return result;
    }

    @PutMapping(path="/api/orders/cancel/{order_id}")
    public SushiOrderUpdateResp cancelOrder(@PathVariable int order_id){
        SushiOrderUpdateResp result = new SushiOrderUpdateResp();
        Optional<SushiOrder> order = sushiOrderRepo.findById(order_id);

        SushiOrder orderInfo = new SushiOrder();
        orderInfo = order.get();
        orderInfo.setStatusId(5);
        sushiOrderRepo.save(orderInfo);
        result.setCode("0");
        result.setMsg("Order cancelled");
    return result;
    }

    @PutMapping(path="/api/orders/pause/{order_id}")
    public SushiOrderUpdateResp pauseOrder(@PathVariable int order_id){
        SushiOrderUpdateResp result = new SushiOrderUpdateResp();
        Optional<SushiOrder> order = sushiOrderRepo.findById(order_id);

        SushiOrder orderInfo = new SushiOrder();
        orderInfo = order.get();
        orderInfo.setStatusId(3);
        sushiOrderRepo.save(orderInfo);
        result.setCode("0");
        result.setMsg("Order paused");
        return result;
    }

    @PutMapping(path="/api/orders/resume/{order_id}")
    public SushiOrderUpdateResp resumeOrder(@PathVariable int order_id){
        SushiOrderUpdateResp result = new SushiOrderUpdateResp();
        Optional<SushiOrder> order = sushiOrderRepo.findById(order_id);

        SushiOrder orderInfo = new SushiOrder();
        orderInfo = order.get();
        orderInfo.setStatusId(2);
        sushiOrderRepo.save(orderInfo);
        result.setCode("0");
        result.setMsg("Order resumed");
        return result;
    }

}
