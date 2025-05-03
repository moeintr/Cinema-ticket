package com.mycompany.cinema.entity;

import java.io.Serializable;

public class Film implements Serializable {
    private Integer filmId;
    private String title;
    private Integer availableTickets;
    private Long price;

    public Film() {
    }

    public Film(Integer filmId, String title, Integer availableTickets, Long price) {
        this.filmId = filmId;
        this.title = title;
        this.availableTickets = availableTickets;
        this.price = price;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public Film setFilmId(Integer filmId) {
        this.filmId = filmId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Film setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getAvailableTickets() {
        return availableTickets;
    }

    public Film setAvailableTickets(Integer availableTickets) {
        this.availableTickets = availableTickets;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public Film setPrice(Long price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return filmId + "," + title + "," + availableTickets + "," + price + "\n";
    }
}
