package com.mod.mycat.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

@Entity
@Setter
@Getter
public class BookInfo implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Long author;

    @Transient
    private String authorName;


}