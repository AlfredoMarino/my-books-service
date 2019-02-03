package com.alfredomarino.mislibros.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Autor
 */
@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @Column(name = "idAutor")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idAutor;

    @Column(name = "nombre")
    private String nombre;

    public Autor() {
        
    }


    /**
     * @return the idAutor
     */
    public Long getIdAutor() {
        return idAutor;
    }

    /**
     * @param idAutor the idAutor to set
     */
    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}