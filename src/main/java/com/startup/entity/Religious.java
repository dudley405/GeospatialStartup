package com.startup.entity;
// Generated Mar 26, 2016 2:04:24 PM by Hibernate Tools 5.1.0.Alpha1


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Religious generated by hbm2java
 */
@Entity
@Table(name="religious"
    ,schema="public"
)
public class Religious  implements java.io.Serializable {


     private String id;
     private Serializable geom;
     private String stateAbbr;
     private Double mainlineR;
     private String state0;
     private Double adjustedA;
     private Double totalCong;
     private Double population;
     private Double mainlineA;
     private Double mainlineC;
     private Double totalAdhe;
     private String county0;

    public Religious() {
    }

	
    public Religious(String id) {
        this.id = id;
    }
    public Religious(String id, Serializable geom, String stateAbbr, Double mainlineR, String state0, Double adjustedA, Double totalCong, Double population, Double mainlineA, Double mainlineC, Double totalAdhe, String county0) {
       this.id = id;
       this.geom = geom;
       this.stateAbbr = stateAbbr;
       this.mainlineR = mainlineR;
       this.state0 = state0;
       this.adjustedA = adjustedA;
       this.totalCong = totalCong;
       this.population = population;
       this.mainlineA = mainlineA;
       this.mainlineC = mainlineC;
       this.totalAdhe = totalAdhe;
       this.county0 = county0;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    
    @Column(name="geom")
    public Serializable getGeom() {
        return this.geom;
    }
    
    public void setGeom(Serializable geom) {
        this.geom = geom;
    }

    
    @Column(name="State Abbr")
    public String getStateAbbr() {
        return this.stateAbbr;
    }
    
    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    
    @Column(name="Mainline R", precision=17, scale=17)
    public Double getMainlineR() {
        return this.mainlineR;
    }
    
    public void setMainlineR(Double mainlineR) {
        this.mainlineR = mainlineR;
    }

    
    @Column(name="State0")
    public String getState0() {
        return this.state0;
    }
    
    public void setState0(String state0) {
        this.state0 = state0;
    }

    
    @Column(name="Adjusted A", precision=17, scale=17)
    public Double getAdjustedA() {
        return this.adjustedA;
    }
    
    public void setAdjustedA(Double adjustedA) {
        this.adjustedA = adjustedA;
    }

    
    @Column(name="Total Cong", precision=17, scale=17)
    public Double getTotalCong() {
        return this.totalCong;
    }
    
    public void setTotalCong(Double totalCong) {
        this.totalCong = totalCong;
    }

    
    @Column(name="Population", precision=17, scale=17)
    public Double getPopulation() {
        return this.population;
    }
    
    public void setPopulation(Double population) {
        this.population = population;
    }

    
    @Column(name="Mainline A", precision=17, scale=17)
    public Double getMainlineA() {
        return this.mainlineA;
    }
    
    public void setMainlineA(Double mainlineA) {
        this.mainlineA = mainlineA;
    }

    
    @Column(name="Mainline C", precision=17, scale=17)
    public Double getMainlineC() {
        return this.mainlineC;
    }
    
    public void setMainlineC(Double mainlineC) {
        this.mainlineC = mainlineC;
    }

    
    @Column(name="Total Adhe", precision=17, scale=17)
    public Double getTotalAdhe() {
        return this.totalAdhe;
    }
    
    public void setTotalAdhe(Double totalAdhe) {
        this.totalAdhe = totalAdhe;
    }

    
    @Column(name="County0")
    public String getCounty0() {
        return this.county0;
    }
    
    public void setCounty0(String county0) {
        this.county0 = county0;
    }




}

