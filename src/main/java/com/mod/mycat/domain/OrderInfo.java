package com.mod.mycat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orderinfo")
@Setter
@Getter
public class OrderInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long total;

    private Long userid;

    private Date createdate;

    private String address;

    private Long addressid;

    private String remark;

    private Integer status;

    private Integer paystatus;

    private String payno;

    private String expressno;

    private String express;

    private Date updatedate;

    @Transient
    private List<OrderItem> items;

}