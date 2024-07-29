package com.techspine.crs.repository;

import com.techspine.crs.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminCarRepository extends JpaRepository<Car,Integer> {

    @Query("SELECT c FROM Car c WHERE c.user.id = :userId")
    List<Car> findAllCarsByUser(@Param("userId") Integer userId);


}
