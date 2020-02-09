package by.bsuir.filmography.service;

import by.bsuir.filmography.model.Director;
import by.bsuir.filmography.model.Film;

import java.time.LocalDate;
import java.util.List;

public interface FilmService {
    List<Film> searchFilmByParameters(int id, LocalDate startDate);
    List<Director> allDirectors();
    Director findDirectorById(int id);
    List<Film> allFilms();
}
