package com.mod.mycat.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userinfo")
@Setter
@Getter
public class BookInfo implements Serializable {
    @Id
    private Long id;

    private String name;

    private Long author;

    @Transient
    private String authorName;


}