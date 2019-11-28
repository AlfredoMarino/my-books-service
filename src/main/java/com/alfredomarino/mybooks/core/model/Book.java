package com.alfredomarino.mybooks.core.model;

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
 * Book
 */
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "idbook")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idBook;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "synopsis")
    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "idauthor")
    private Author author;

    @Column(name = "publicationdate")
    private Date publicationDate;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;

    @Column(name = "image")
    private String image;

    @Column(name = "isbn10")
    private String isbn10;

    @Column(name = "isbn13")
    private String isbn13;

    @Column(name = "idgoogle")
    private String idGoogle;

    public Book() {
        
    }

    public Book(String title, String subtitle, String synopsis, Author author, Date publicationDate, Category category, String image, String isbn10, String isbn13, String idGoogle) {
        this.title = title;
        this.subtitle = subtitle;
        this.synopsis = synopsis;
        this.author = author;
        this.publicationDate = publicationDate;
        this.category = category;
        this.image = image;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.idGoogle = idGoogle;
    }

    /**
     * @return the idBook
     */
    public Long getIdBook() {
        return idBook;
    }

    /**
     * @param idBook the idBook to set
     */
    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the subtitle
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * @param subtitle the subtitle to set
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * @return the synopsis
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * @param synopsis the synopsis to set
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * @return the author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * @return the publicationDate
     */
    public Date getPublicationDate() {
        return publicationDate;
    }

    /**
     * @param publicationDate the publicationDate to set
     */
    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
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