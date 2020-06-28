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
    private Long bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "synopsis")
    private String description;

    //TODO PUEDEN SER MAS DE UN AUTHOR
    @ManyToOne
    @JoinColumn(name = "idauthor")
    private Author author;

    @Column(name = "publicationdate")
    private Date publicationDate;

    //TODO PUEDE TENER MAS CATEGORIAS
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
    private String googleId;

    /**
     * @return the bookId
     */
    public Long getBookId() {
        return bookId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(Long bookId) {
        this.bookId = bookId;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return the googleId
     */
    public String getGoogleId() {
        return googleId;
    }

    /**
     * @param googleId the googleId to set
     */
    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", publicationDate=" + publicationDate +
                ", category=" + category +
                ", image='" + image + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", googleId='" + googleId + '\'' +
                '}';
    }
}