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
 * Libro
 */
@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @Column(name = "idLibro")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idLibro;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "subtitulo")
    private String subtitulo;

    @Column(name = "sinopsis")
    private String sinopsis;

    @ManyToOne
    @JoinColumn(name = "idautor")
    private Autor autor;

    @Column(name = "fechapublicacion")
    private Date fechaPublicacion;


    @ManyToOne
    @JoinColumn(name = "idgenero")
    private Genero genero;

    public Libro() {
        
    }



}