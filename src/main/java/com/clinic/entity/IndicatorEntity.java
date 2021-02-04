package com.clinic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "indicator", schema = "mini_clinic")
public class IndicatorEntity
{
    @Id
    @Column(name = "indicator_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int indicatorId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "threshold")
    private int threshold;
}
