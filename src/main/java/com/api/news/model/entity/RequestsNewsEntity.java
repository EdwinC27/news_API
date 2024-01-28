package com.api.news.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "generated_information")
public class RequestsNewsEntity {
     public RequestsNewsEntity() {

     }

     public RequestsNewsEntity(String time, String type, String search, String totalResults) {
        this.time = time;
        this.type = type;
        this.search = search;
        this.totalResults = totalResults;
     }

     @Basic
     @Id
     private String time;

     @Basic
     private String type;

     @Basic
     private String search;

     @Basic
     @Column(name = "total_results")
     private String totalResults;


    public void setTime(String time) {
        this.time = time;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }
}
