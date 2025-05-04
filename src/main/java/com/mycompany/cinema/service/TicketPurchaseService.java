package com.mycompany.cinema.service;

import com.mycompany.cinema.entity.Film;
import com.mycompany.cinema.entity.TicketPurchase;
import com.mycompany.cinema.entity.User;
import com.mycompany.cinema.exception.NotEnoughTicketException;
import com.mycompany.cinema.exception.NotFoundFilmException;
import com.mycompany.cinema.repository.FilmRepository;
import com.mycompany.cinema.repository.TicketPurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketPurchaseService {
    private final TicketPurchaseRepository ticketPurchaseRepository;
    private final FilmRepository filmRepository;
    public List<TicketPurchase> getAll() {
        return ticketPurchaseRepository.findAll();
    }

    @Transactional
    public TicketPurchase buyTicket(User user, String title, Integer totalNumber) {
        Film foundFilm = filmRepository.findFilmByTitle(title)
                .orElseThrow(() -> new NotFoundFilmException("film not found"));

        if (totalNumber > foundFilm.getAvailableTickets()) {
            throw new NotEnoughTicketException("film has not enough ticket");
        }

        foundFilm.setAvailableTickets(foundFilm.getAvailableTickets() - totalNumber);
        filmRepository.save(foundFilm);

        TicketPurchase ticketPurchase = new TicketPurchase()
                .setUser(user)
                .setFilm(foundFilm)
                .setTotalNumber(totalNumber)
                .setTotalCost(totalNumber * foundFilm.getPrice());

        ticketPurchaseRepository.save(ticketPurchase);
        return ticketPurchase;
    }
}
