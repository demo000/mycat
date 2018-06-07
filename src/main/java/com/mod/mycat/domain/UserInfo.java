package com.mod.mycat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Setter
@Getter
public class UserInfo implements Serializable {

    @Id
    private Long id;
    private String name;
    private String address;
}
