package com.example.android_19;

public class UserSimple {
    private String Country;
    private String CountryCode;
    private Integer NewConfirmed;
    private Integer TotalConfirmed;
    private Integer NewDeaths;
    private Integer TotalDeaths;
    private Integer NewRecovered;
    private Integer TotalRecovered;
    private boolean expanded;

    public UserSimple(String country, String countrycode, Integer newConfirmed, Integer totalConfirmed, Integer newDeaths, Integer totalDeaths, Integer newRecovered, Integer totalRecovered) {
        Country = country;
        CountryCode = countrycode;
        NewConfirmed = newConfirmed;
        TotalConfirmed = totalConfirmed;
        NewDeaths = newDeaths;
        TotalDeaths = totalDeaths;
        NewRecovered = newRecovered;
        TotalRecovered = totalRecovered;
        this.expanded = true;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countrycode) {
        CountryCode = countrycode;
    }

    public Integer getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(Integer newConfirmed) {
        NewConfirmed = newConfirmed;
    }

    public Integer getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(Integer totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public Integer getNewDeaths() {
        return NewDeaths;
    }

    public void setNewDeaths(Integer newDeaths) {
        NewDeaths = newDeaths;
    }

    public Integer getTotalDeaths() {
        return TotalDeaths;
    }

    public void setTotalDeaths(Integer totalDeaths) {
        TotalDeaths = totalDeaths;
    }

    public Integer getNewRecovered() {
        return NewRecovered;
    }

    public void setNewRecovered(Integer newRecovered) {
        NewRecovered = newRecovered;
    }

    public Integer getTotalRecovered() {
        return TotalRecovered;
    }

    public void setTotalRecovered(Integer totalRecovered) {
        TotalRecovered = totalRecovered;
    }
}
