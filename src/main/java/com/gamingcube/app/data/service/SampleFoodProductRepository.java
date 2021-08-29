package com.gamingcube.app.data.service;

import com.gamingcube.app.data.entity.SampleFoodProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import javax.persistence.Lob;

public interface SampleFoodProductRepository extends JpaRepository<SampleFoodProduct, Integer> {

}