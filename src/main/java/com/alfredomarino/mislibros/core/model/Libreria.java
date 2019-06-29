package com.alfredomarino.mislibros.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Libreria
 */
@Entity
@Table(name = "libreria")
public class Libreria {

    @Id
    @Column(name = "idlibreria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibreria;
    
    @ManyToOne
    @JoinColumn(name = "idpersona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "idlibro")
    private Libro libro;

    @Column(name = "fechainicio")
    private Date fechaInicio;

    @Column(name = "fechafin")
    private Date fechaFin;

    @ManyToOne
    @JoinColumn(name = "idpaisinicio")
    private Pais paisInicio;

    @ManyToOne
    @JoinColumn(name = "idestadoinicio")
    private Estado estadoInicio;

    @ManyToOne
    @JoinColumn(name = "idpaisfin")
    private Pais paisFin;

    @ManyToOne
    @JoinColumn(name = "idestadofin")
    private Estado estadoFin;

    @Column(name = "valoracion")
    private Double valoracion;

    @Column(name = "nota")
    private String nota;

    @Column(name = "fechacreacion")
    private Date fechaCreacion;

    public Libreria() {
        
    }

    /**
     * @return the idLibreria
     */
    public Long getIdLibreria() {
        return idLibreria;
    }

    /**
     * @param idLibreria the idLibreria to set
     */
    public void setIdLibreria(Long idLibreria) {
        this.idLibreria = idLibreria;
    }

    /**
     * @return the persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * @return the libro
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * @param libro the libro to set
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the paisInicio
     */
    public Pais getPaisInicio() {
        return paisInicio;
    }

    /**
     * @param paisInicio the paisInicio to set
     */
    public void setPaisInicio(Pais paisInicio) {
        this.paisInicio = paisInicio;
    }

    /**
     * @return the estadoInicio
     */
    public Estado getEstadoInicio() {
        return estadoInicio;
    }

    /**
     * @param estadoInicio the estadoInicio to set
     */
    public void setEstadoInicio(Estado estadoInicio) {
        this.estadoInicio = estadoInicio;
    }

    /**
     * @return the paisFin
     */
    public Pais getPaisFin() {
        return paisFin;
    }

    /**
     * @param paisFin the paisFin to set
     */
    public void setPaisFin(Pais paisFin) {
        this.paisFin = paisFin;
    }

    /**
     * @return the estadoFin
     */
    public Estado getEstadoFin() {
        return estadoFin;
    }

    /**
     * @param estadoFin the estadoFin to set
     */
    public void setEstadoFin(Estado estadoFin) {
        this.estadoFin = estadoFin;
    }

    /**
     * @return the valoracion
     */
    public Double getValoracion() {
        return valoracion;
    }

    /**
     * @param valoracion the valoracion to set
     */
    public void setValoracion(Double valoracion) {
        this.valoracion = valoracion;
    }

    /**
     * @return the nota
     */
    public String getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(String nota) {
        this.nota = nota;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }



}