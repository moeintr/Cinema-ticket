package com.mycompany.cinema.service;

import com.mycompany.cinema.entity.Film;
import com.mycompany.cinema.entity.TicketPurchase;
import com.mycompany.cinema.exception.NotEnoughTicketException;
import com.mycompany.cinema.exception.NotFoundFilmException;
import com.mycompany.cinema.repository.FilmFileRepository;

import java.util.List;

public class FilmService implements Service<Film> {
    private FilmService() {
    }
    private static final FilmService FILM_SERVICE = new FilmService();

    public static FilmService getInstance() {
        return FILM_SERVICE;
    }

    public List<Film> getAll() {
        return FilmFileRepository.getInstance().findAll();
    }

    public void saveAll(List<Film> films) {
        FilmFileRepository.getInstance().saveAll(films);
    }

    public TicketPurchase buyTicket(String title, Integer totalNumber) {
        List<Film> films = getAll();
        Film foundFilm = films.stream()
                .filter(film -> film.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElseThrow(() -> new NotFoundFilmException("film not found"));

        if (totalNumber > foundFilm.getAvailableTickets()) {
            throw new NotEnoughTicketException("film has not enough ticket");
        }

        foundFilm.setAvailableTickets(foundFilm.getAvailableTickets() - totalNumber);
        saveAll(films);

        List<TicketPurchase> ticketPurchases = TicketPurchaseService.getInstance().getAll();

        TicketPurchase ticketPurchase = new TicketPurchase()
                .setFilmId(foundFilm.getFilmId())
                .setTotalNumber(totalNumber)
                .setTotalCost(totalNumber * foundFilm.getPrice());
        ticketPurchase.generateId(ticketPurchases);

        ticketPurchases.add(ticketPurchase);
        TicketPurchaseService.getInstance().saveAll(ticketPurchases);
        return ticketPurchase;
    }

}
