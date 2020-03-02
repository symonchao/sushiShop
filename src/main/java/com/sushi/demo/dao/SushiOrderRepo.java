package com.sushi.demo.dao;

import com.sushi.demo.model.SushiOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SushiOrderRepo extends JpaRepository<SushiOrder,Integer> {

}
