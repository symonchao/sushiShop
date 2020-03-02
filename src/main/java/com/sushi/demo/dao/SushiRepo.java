package com.sushi.demo.dao;

import com.sushi.demo.model.Sushi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SushiRepo extends JpaRepository<Sushi,Integer> {
    Optional<Sushi> findByName(@Param("name")String name);
}
