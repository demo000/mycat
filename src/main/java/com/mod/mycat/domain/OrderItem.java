package com.mod.mycat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderitem")
@Setter
@Getter
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;

    private String productname;

    private String unit;

    private String spec;

    private Long orderid;

    private Integer num;

    private Long price;

    private Long total;


}