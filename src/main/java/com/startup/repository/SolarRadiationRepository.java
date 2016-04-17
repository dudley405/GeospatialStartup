package com.startup.repository;

import com.google.code.ssm.api.ParameterValueKeyProvider;
import com.google.code.ssm.api.ReadThroughMultiCache;
import com.google.code.ssm.api.ReadThroughSingleCache;
import com.startup.entity.SolarRadiationLatilt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Cacheable;
import java.util.List;

/**
 * Created by Justin on 3/30/2016.
 */
@Repository
@Cacheable
public interface SolarRadiationRepository extends CrudRepository<SolarRadiationLatilt, Long> {

    @ReadThroughMultiCache(namespace = "solar", expiration = 3600)
    List<SolarRadiationLatilt> findByPotential(@ParameterValueKeyProvider String potential);

}
