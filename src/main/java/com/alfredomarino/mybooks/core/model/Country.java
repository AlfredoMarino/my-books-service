package com.alfredomarino.mybooks.core.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Country
 */
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "idcountry")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idCountry;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private Set<Region> regions;

    public Country() {
        
    }


    /**
     * @return the idCountry
     */
    public Long getIdCountry() {
        return idCountry;
    }

    /**
     * @param idCountry the idCountry to set
     */
    public void setIdCountry(Long idCountry) {
        this.idCountry = idCountry;
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

    /**
     * @return the regions
     */
    public Set<Region> getRegions() {
        return regions;
    }

    /**
     * @param regions the regions to set
     */
    public void setRegions(Set<Region> regions) {
        this.regions = regions;
    }
}