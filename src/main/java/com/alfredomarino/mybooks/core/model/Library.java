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
 * Library
 */
@Entity
@Table(name = "library")
public class Library {

    @Id
    @Column(name = "idlibrary")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibrary;
    
    @ManyToOne
    @JoinColumn(name = "idperson")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "idbook")
    private Book book;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "enddate")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "idinitialcountry")
    private Country initialCountry;

    @ManyToOne
    @JoinColumn(name = "idinitialregion")
    private Region initialRegion;

    @ManyToOne
    @JoinColumn(name = "idendcountry")
    private Country finalCountry;

    @ManyToOne
    @JoinColumn(name = "idendregion")
    private Region finalRegion;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "note")
    private String note;

    @Column(name = "creationdate")
    private Date creationDate;

    public Library() {
        
    }

    /**
     * @return the idLibrary
     */
    public Long getIdLibrary() {
        return idLibrary;
    }

    /**
     * @param idLibrary the idLibrary to set
     */
    public void setIdLibrary(Long idLibrary) {
        this.idLibrary = idLibrary;
    }

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
                "idLibrary=" + idLibrary +
                ", person=" + person +
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