package com.mycompany.cinema.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.cinema.entity.Film;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilmFileRepository implements FileRepository<Film> {
    private FilmFileRepository(){}
    private static final FilmFileRepository FILM_FILE_REPOSITORY = new FilmFileRepository();

    public static FilmFileRepository getInstance() {
        return FILM_FILE_REPOSITORY;
    }
    private final File file = new File("films.json");
    private final String CHARSET_NAME = "utf-8";
    private final Gson gson = new Gson();

    @Override
    public void saveAll(List<Film> films) {
        try {
            String json = gson.toJson(films);
            FileUtils.writeStringToFile(file, json, CHARSET_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Film> findAll() {
        try {
            if (!file.exists()) return new ArrayList<>(List.of());
            String content = FileUtils.readFileToString(file, CHARSET_NAME);
            List<Film> films = gson.fromJson(content, new TypeToken<List<Film>>(){}.getType());
            return films;
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
