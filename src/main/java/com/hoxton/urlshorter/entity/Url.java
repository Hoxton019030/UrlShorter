package com.hoxton.urlshorter.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "url")
public class Url {
    @Id
    private Integer id;
    @Column(name = "origin_url")
    private String originUrl;
    @Column(name = "short_url")
    private String shortUrl;
    @Column(name = "create_time")
    private Date createTime;

}
