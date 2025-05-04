package com.mycompany.cinema.controller;

import com.mycompany.cinema.entity.Film;

import com.mycompany.cinema.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/film")
public class FilmController {

    private final FilmService filmService;

    @GetMapping("/getAll")
    public List<Film> getAll() {
        return filmService.getAll();
    }
    @PostMapping("/save")
    public void save(Film film) {
        filmService.save(film);
    }
}
