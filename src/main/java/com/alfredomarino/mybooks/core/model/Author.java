package com.alfredomarino.mybooks.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author
 */
@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "idauthor")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idAuthor;

    @Column(name = "name")
    private String name;

    public Author() {
        
    }

    public Author(String name) {
        this.name = name;
    }

    /**
     * @return the idAuthor
     */
    public Long getIdAuthor() {
        return idAuthor;
    }

    /**
     * @param idAuthor the idAuthor to set
     */
    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
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
}