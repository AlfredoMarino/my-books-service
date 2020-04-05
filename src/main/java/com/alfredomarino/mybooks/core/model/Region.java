package com.alfredomarino.mybooks.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Region
 */
@Entity
@Table(name = "region")
public class Region {

    @Id
    @Column(name = "idregion")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idRegion;

    @ManyToOne
    @JoinColumn(name = "idcountry")
    @JsonIgnore
    private Country country;

    @Column(name = "name")
    private String name;

    public Region() {
        
    }

    /**
     * @return the idRegion
     */
    public Long getIdRegion() {
        return idRegion;
    }

    /**
     * @param idRegion the idRegion to set
     */
    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }


    /**
     * @return the country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(Country country) {
        this.country = country;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Region{" +
                "idRegion=" + idRegion +
                ", country=" + country +
                ", name='" + name + '\'' +
                '}';
    }
}