package edu.iit.sat.itmd4515.a20498639.domain;

import javax.validation.constraints.*;

import java.time.LocalDate;

public class Country {
    @NotNull
    @Positive
    private Integer countryId;
    @NotBlank
    private String countryName;
    @PastOrPresent
    private LocalDate lastUpdate;

    public Country() {
    }

    public Country(Integer countryId, String countryName, LocalDate lastUpdate) {
        this.countryId = countryId;
        this.countryName = countryName;
        this.lastUpdate = lastUpdate;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", countryName=" + countryName +
                ", lastUpdate='" + lastUpdate +
                '}';
    }
}
