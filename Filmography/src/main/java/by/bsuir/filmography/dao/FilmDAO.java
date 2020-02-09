package by.bsuir.filmography.dao;

import by.bsuir.filmography.model.Director;
import by.bsuir.filmography.model.Film;

import java.util.Date;
import java.time.LocalDate;
import java.util.List;

public interface FilmDAO {
    List<Director> allDirectors();
    Director findDirectorById(int id);
    List<Film> allFilms();
    List<Film> getFilmByLocalDate(LocalDate date);
    List<Film> findFilmByDirector(Director director);
    List<Film> searchByParameters(int id, LocalDate date);
}
