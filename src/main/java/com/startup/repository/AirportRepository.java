package com.startup.repository;

import com.startup.entity.AirportsUs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Justin on 3/26/2016.
 */
@Repository
public interface AirportRepository extends CrudRepository<AirportsUs, Integer> {

}
