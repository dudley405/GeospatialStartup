package com.startup.repository;

import com.startup.entity.SolarRadiationLatilt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Justin on 3/30/2016.
 */
@Repository
public interface SolarRadiationRepository extends CrudRepository<SolarRadiationLatilt, Long> {
}
