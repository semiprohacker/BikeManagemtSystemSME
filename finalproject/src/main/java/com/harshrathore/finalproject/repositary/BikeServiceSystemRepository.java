package com.harshrathore.finalproject.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshrathore.finalproject.entity.Bike;

public interface BikeServiceSystemRepository extends JpaRepository<Bike, Integer> {

}
