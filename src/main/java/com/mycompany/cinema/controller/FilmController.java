package com.mycompany.cinema.controller;

import com.mycompany.cinema.entity.Film;
import com.mycompany.cinema.entity.TicketPurchase;
import com.mycompany.cinema.service.FilmService;

import java.util.List;

public class FilmController {

    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    public List<Film> getAll() {
        return FilmService.getInstance().getAll();
    }
    public void saveAll(List<Film> films) {
        FilmService.getInstance().saveAll(films);
    }
    public TicketPurchase buyTicket(String title, Integer totalNumber) {
        return FilmService.getInstance().buyTicket(title, totalNumber);
    }
}
