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
    @Column(name = "idlibro")
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

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "isbn10")
    private String isbn10;

    @Column(name = "isbn13")
    private String isbn13;

    @Column(name = "idgoogle")
    private String idGoogle;

    public Libro() {
        
    }

    public Libro(String titulo, String subtitulo, String sinopsis, Autor autor, Date fechaPublicacion, Genero genero, String imagen, String isbn10, String isbn13, String idGoogle) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.sinopsis = sinopsis;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.genero = genero;
        this.imagen = imagen;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.idGoogle = idGoogle;
    }

    /**
     * @return the idLibro
     */
    public Long getIdLibro() {
        return idLibro;
    }

    /**
     * @param idLibro the idLibro to set
     */
    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the subtitulo
     */
    public String getSubtitulo() {
        return subtitulo;
    }

    /**
     * @param subtitulo the subtitulo to set
     */
    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    /**
     * @return the sinopsis
     */
    public String getSinopsis() {
        return sinopsis;
    }

    /**
     * @param sinopsis the sinopsis to set
     */
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    /**
     * @return the autor
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    /**
     * @return the fechaPublicacion
     */
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * @param fechaPublicacion the fechaPublicacion to set
     */
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * @return the genero
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the isbn10
     */
    public String getIsbn10() {
        return isbn10;
    }

    /**
     * @param isbn10 the isbn10 to set
     */
    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    /**
     * @return the isbn13
     */
    public String getIsbn13() {
        return isbn13;
    }

    /**
     * @param isbn13 the isbn13 to set
     */
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    /**
     * @return the idGoogle
     */
    public String getIdGoogle() {
        return idGoogle;
    }

    /**
     * @param idGoogle the idGoogle to set
     */
    public void setIdGoogle(String idGoogle) {
        this.idGoogle = idGoogle;
    }



}