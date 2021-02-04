package com.clinic.repository;

import com.clinic.entity.IndicatorEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IndicatorJpa extends JpaRepository<IndicatorEntity, Integer>
{
    String FIND_ALL_INDICATORS = "findAllIndicators";

    @Cacheable(FIND_ALL_INDICATORS)
    @Override
    List<IndicatorEntity> findAll();

    @CacheEvict(value=FIND_ALL_INDICATORS, allEntries=true)
    @Override
    <S extends IndicatorEntity> S save(S s);
}
