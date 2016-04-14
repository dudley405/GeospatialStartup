package com.startup.repository;

import com.startup.entity.SolarRadiationLatilt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Justin on 3/30/2016.
 */
@Repository
public interface SolarRadiationRepository extends CrudRepository<SolarRadiationLatilt, Long> {

    List<SolarRadiationLatilt> findFirstByOrderByIdAsc();

}
