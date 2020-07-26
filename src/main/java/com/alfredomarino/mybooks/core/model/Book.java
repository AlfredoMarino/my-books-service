package com.alfredomarino.mybooks.core.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

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

    @Column(name = "description")
    private String description;

    @JoinTable(
            name = "written",
            joinColumns = @JoinColumn(name = "bookid", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "authorid", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors;

    @Column(name = "publicationdate")
    private Date publicationDate;

    @JoinTable(
            name = "categorize",
            joinColumns = @JoinColumn(name = "bookid", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "categoryid", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Category> categories;

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
     * @return the authors
     */
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
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
     * @return the categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
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
                ", authors=" + authors +
                ", publicationDate=" + publicationDate +
                ", categories=" + categories +
                ", image='" + image + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", googleId='" + googleId + '\'' +
                '}';
    }
}