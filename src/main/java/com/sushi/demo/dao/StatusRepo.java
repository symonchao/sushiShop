package com.sushi.demo.dao;

import com.sushi.demo.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepo extends JpaRepository<Status,Integer> {
}
