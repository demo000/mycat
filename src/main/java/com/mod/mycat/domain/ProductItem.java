package com.mod.mycat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productitem")
@Setter
@Getter
public class ProductItem {
    @Id
    @GeneratedValue
    private Long id;

    private String spec;

    private String productname;

    private Long productid;

    private String unit;

    private Long price;

}