package com.example.spcprofession.models;

public class Post {
    String Area,Des,Name,Prof;

    public Post() {
    }

    public Post(String area, String des, String name, String prof) {
        Area = area;
        Des = des;
        Name = name;
        Prof = prof;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProf() {
        return Prof;
    }

    public void setProf(String prof) {
        Prof = prof;
    }
}
