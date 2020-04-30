package com.example.android_19;

import java.util.List;

public class GeneralInfo {
    gData Global;
    List<UserSimple> Countries;



    public class gData {
        private Integer NewConfirmed;
        private Integer TotalConfirmed;
        private Integer NewDeaths;
        private Integer TotalDeaths;
        private Integer NewRecovered;
        private Integer TotalRecovered;

        public gData(Integer newConfirmed, Integer totalConfirmed, Integer newDeaths, Integer totalDeaths, Integer newRecovered, Integer totalRecovered) {
            NewConfirmed = newConfirmed;
            TotalConfirmed = totalConfirmed;
            NewDeaths = newDeaths;
            TotalDeaths = totalDeaths;
            NewRecovered = newRecovered;
            TotalRecovered = totalRecovered;
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

    public GeneralInfo(gData global, List<UserSimple> countries) {
        Global = global;
        Countries = countries;
    }


    public gData getGlobal() {
        return Global;
    }

    public void setGlobal(gData global) {
        Global = global;
    }

    public List<UserSimple> getCountries() {
        return Countries;
    }

    public void setCountries(List<UserSimple> countries) {
        Countries = countries;
    }
}



