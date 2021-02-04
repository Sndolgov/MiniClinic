package com.clinic.repository;

import com.clinic.entity.IndicatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndicatorJpa extends JpaRepository<IndicatorEntity, Integer>
{
}
