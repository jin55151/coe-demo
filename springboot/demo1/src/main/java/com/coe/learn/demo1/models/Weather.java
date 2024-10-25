package com.coe.learn.demo1.models;

import java.util.List;

public class Weather {
    public List<InnerWeather> weather;
    public Object coord;
    public String base;
    public Object main;
    public int visibility;
    public Object wind;
    public Object clouds;
    public int dt;
    public Object sys;
    public int timezone;
    public int id;
    public int cod;
    public String name;


    /**
     * InnerWeather
     */
    public static class InnerWeather {
        public int id;
        public String main;
        public String description;
        public String icon;

        public InnerWeather() {}

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getMain() {
            return main;
        }
        public void setMain(String main) {
            this.main = main;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String getIcon() {
            return icon;
        }
        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String toString() {
            return this.main + ": " + this.description;
        }
    }

    public List<InnerWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<InnerWeather> weather) {
        this.weather = weather;
    }

}
