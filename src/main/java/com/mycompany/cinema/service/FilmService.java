package com.mycompany.cinema.service;

import com.mycompany.cinema.entity.Film;
import com.mycompany.cinema.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService{
    private final FilmRepository filmRepository;

    public List<Film> getAll() {
        return filmRepository.findAll();
    }
    public void save(Film film) {
        filmRepository.save(film);
    }
}
