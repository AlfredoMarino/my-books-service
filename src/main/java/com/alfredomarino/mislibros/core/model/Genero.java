package com.alfredomarino.mislibros.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Genero
 */
@Entity
@Table(name = "genero")
public class Genero {

    @Id
    @Column(name = "idgenero")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idGenero;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nombreingles")
    private String nombreIngles;

    public Genero() {
        
    }

    public Genero(String nombre, String nombreIngles) {
        this.nombre = nombre;
        this.nombreIngles = nombreIngles;
    }

    /**
     * @return the idGenero
     */
    public Long getIdGenero() {
        return idGenero;
    }

    /**
     * @param idGenero the idGenero to set
     */
    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
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

    /**
     * @return the nombreIngles
     */
    public String getNombreIngles() {
        return nombreIngles;
    }

    /**
     * @param nombreIngles the nombreIngles to set
     */
    public void setNombreIngles(String nombreIngles) {
        this.nombreIngles = nombreIngles;
    }


}