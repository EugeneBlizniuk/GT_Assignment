package by.bsuir.filmography.service.impl;

import by.bsuir.filmography.dao.FilmDAO;
import by.bsuir.filmography.model.Director;
import by.bsuir.filmography.model.Film;
import by.bsuir.filmography.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    private FilmDAO filmDAO;

    @Autowired
    public void setFilmDAO(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }
    @Override
    @Transactional
    public List<Film> searchFilmByParameters(int id, LocalDate startDate) {
        if(id >= 0 || startDate != null) {
            return filmDAO.searchByParameters(id, startDate);
        } else {
            return null;
        }
    }
    @Override
    @Transactional
    public List<Director> allDirectors() {
        return filmDAO.allDirectors();
    }
    @Override
    @Transactional
    public Director findDirectorById(int id) {
        if(id >= 0) {
            return filmDAO.findDirectorById(id);
        } else {
            return null;
        }
    }
    @Override
    @Transactional
    public List<Film> allFilms() {
        return filmDAO.allFilms();
    }
}
