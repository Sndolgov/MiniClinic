package com.clinic.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "indicator", schema = "mini_clinic")
public class IndicatorEntity
{
    @Id
    @Column(name = "indicator_id")
    private int indicatorId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "threshold")
    private int threshold;
}
