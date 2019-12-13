package com.alfredomarino.mybooks.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Category
 */
@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "idcategory")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idCategory;

    @Column(name = "name")
    private String name;

    @Column(name = "englishname")
    private String englishName;

    public Category() {
        
    }

    public Category(String name, String englishName) {
        this.name = name;
        this.englishName = englishName;
    }

    /**
     * @return the idCategory
     */
    public Long getIdCategory() {
        return idCategory;
    }

    /**
     * @param idCategory the idCategory to set
     */
    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
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
     * @return the englishName
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * @param englishName the englishName to set
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", name='" + name + '\'' +
                ", englishName='" + englishName + '\'' +
                '}';
    }
}