package com.surveyApp.survey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "street_address")
    private String streetAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_survey")
    private Date dateOfSurvey;

    @Column(name = "liked_most")
    private String likedMost;

    @Column(name = "interested_in")
    private String interestedIn;

    @Column(name = "likelihood")
    private String likelihood;

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", dateOfSurvey=" + dateOfSurvey +
                ", likedMost='" + likedMost + '\'' +
                ", interestedIn='" + interestedIn + '\'' +
                ", likelihood='" + likelihood + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, streetAddress, city, state, zip, phoneNumber, email, dateOfSurvey,
                likedMost, interestedIn, likelihood);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Survey))
            return false;
        Survey survey = (Survey) o;
        return Objects.equals(id, survey.id) &&
                Objects.equals(firstName, survey.firstName) &&
                Objects.equals(lastName, survey.lastName) &&
                Objects.equals(streetAddress, survey.streetAddress) &&
                Objects.equals(city, survey.city) &&
                Objects.equals(state, survey.state) &&
                Objects.equals(zip, survey.zip) &&
                Objects.equals(phoneNumber, survey.phoneNumber) &&
                Objects.equals(email, survey.email) &&
                Objects.equals(dateOfSurvey, survey.dateOfSurvey) &&
                Objects.equals(likedMost, survey.likedMost) &&
                Objects.equals(interestedIn, survey.interestedIn) &&
                Objects.equals(likelihood, survey.likelihood);
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfSurvey() {
        return dateOfSurvey;
    }

    public String getLikedMost() {
        return likedMost;
    }

    public String getInterestedIn() {
        return interestedIn;
    }

    public String getLikelihood() {
        return likelihood;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfSurvey(Date dateOfSurvey) {
        this.dateOfSurvey = dateOfSurvey;
    }

    public void setLikedMost(String likedMost) {
        this.likedMost = likedMost;
    }

    public void setInterestedIn(String interestedIn) {
        this.interestedIn = interestedIn;
    }

    public void setLikelihood(String likelihood) {
        this.likelihood = likelihood;
    }
}
