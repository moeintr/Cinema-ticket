package com.mycompany.cinema.repository;

import com.mycompany.cinema.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    Optional<Film> findFilmByTitle(String title);
}
