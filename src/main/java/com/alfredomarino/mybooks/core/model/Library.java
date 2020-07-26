package com.alfredomarino.mybooks.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import javax.persistence.*;

/**
 * Library
 */
@Entity
@IdClass(LibraryId.class)
public class Library {

    @Id
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "person_id")
    private Person person;

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "initial_country_id")
    private Country initialCountry;

    @ManyToOne
    @JoinColumn(name = "initial_region_id")
    private Region initialRegion;

    @ManyToOne
    @JoinColumn(name = "end_country_id")
    private Country finalCountry;

    @ManyToOne
    @JoinColumn(name = "end_region_id")
    private Region finalRegion;
    private Double rating;
    private String note;

    @Column(insertable = false, updatable = false)
    private Date creationDate;

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return the book
     */
    public Book getBook() {
        return book;
    }

    /**
     * @param book the book to set
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the initialCountry
     */
    public Country getInitialCountry() {
        return initialCountry;
    }

    /**
     * @param initialCountry the initialCountry to set
     */
    public void setInitialCountry(Country initialCountry) {
        this.initialCountry = initialCountry;
    }

    /**
     * @return the initialRegion
     */
    public Region getInitialRegion() {
        return initialRegion;
    }

    /**
     * @param initialRegion the initialRegion to set
     */
    public void setInitialRegion(Region initialRegion) {
        this.initialRegion = initialRegion;
    }

    /**
     * @return the finalCountry
     */
    public Country getFinalCountry() {
        return finalCountry;
    }

    /**
     * @param finalCountry the finalCountry to set
     */
    public void setFinalCountry(Country finalCountry) {
        this.finalCountry = finalCountry;
    }

    /**
     * @return the finalRegion
     */
    public Region getFinalRegion() {
        return finalRegion;
    }

    /**
     * @param finalRegion the finalRegion to set
     */
    public void setFinalRegion(Region finalRegion) {
        this.finalRegion = finalRegion;
    }

    /**
     * @return the rating
     */
    public Double getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Library{" +
                "person=" + person +
                ", book=" + book +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", initialCountry=" + initialCountry +
                ", initialRegion=" + initialRegion +
                ", finalCountry=" + finalCountry +
                ", finalRegion=" + finalRegion +
                ", rating=" + rating +
                ", note='" + note + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}