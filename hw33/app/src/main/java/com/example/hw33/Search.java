package com.example.hw33;

import java.util.ArrayList;

public class Search {
    private String id;
    private String name;
    private String description;
    private String weight;
    private String temperament;
    private String origin;
    private String life_span;
    private String wikipedia_url;
    private int friendliness;

    public Search(){

    }

    public Search(String id, String name, String description, String weight, String temperament, String origin, String life_span, String wikipedia_url, int friendliness) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.temperament = temperament;
        this.origin = origin;
        this.life_span = life_span;
        this.wikipedia_url = wikipedia_url;
        this.friendliness = friendliness;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public void setWikipedia_url(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }

    public int getFriendliness() {
        return friendliness;
    }

    public void setFriendliness(int friendliness) {
        this.friendliness = friendliness;
    }


    //public ArrayList<Search> results;


}
