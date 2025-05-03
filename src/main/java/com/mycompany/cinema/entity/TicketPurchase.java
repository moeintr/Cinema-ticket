package com.mycompany.cinema.entity;

import java.io.Serializable;
import java.util.List;

public class TicketPurchase implements Serializable {
    private Long id;
    private Integer filmId;
    private Integer totalNumber;
    private Long totalCost;

    public Long getId() {
        return id;
    }

    public TicketPurchase setId(Long id) {
        this.id = id;
        return this;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public TicketPurchase setFilmId(Integer filmId) {
        this.filmId = filmId;
        return this;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public TicketPurchase setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
        return this;
    }

    public Long getTotalCost() {
        return totalCost;
    }

    public TicketPurchase setTotalCost(Long totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public Long generateId(List<TicketPurchase> ticketPurchases) {
        Long id = 1L;
        int size = ticketPurchases.size();
        if (size > 0) {
            TicketPurchase last = ticketPurchases.get(size - 1);
            id = id + last.getId();
        }
        this.id = id;
        return id;
    }

    public TicketPurchase() {
    }

    public TicketPurchase(Long id, Integer filmId, Integer totalNumber, Long totalCost) {
        this.id = id;
        this.filmId = filmId;
        this.totalNumber = totalNumber;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return id + "," + filmId + "," + totalNumber + "," + totalCost + "\n";
    }
}
