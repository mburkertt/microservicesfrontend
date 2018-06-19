package ch.erni.frontend.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Locale;
import java.util.UUID;

public class Ernian {
    private static final int MAX = 30;
    private static final int MIN = 1;
    private static final int LOCALE = 2;
    @NotNull
    private UUID id = java.util.UUID.randomUUID();
    @NotNull
    @Size(min = MIN, max = MAX)
    private String firstName;
    @NotNull
    @Size(min = MIN, max = MAX)
    private String lastName;
    @NotNull
    private Locale country;
    @NotNull
    @Size(min = MIN, max = MAX)
    private String town;
    @NotNull
    @Size(min = MIN, max = MAX)
    private String zip;
    @NotNull
    @Size(min = MIN, max = MAX)
    private String street;
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Locale getCountry() {
        return country;
    }

    public void setCountry(Locale country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
