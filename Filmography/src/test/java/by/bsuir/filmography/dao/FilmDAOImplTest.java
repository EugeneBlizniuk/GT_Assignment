package by.bsuir.filmography.dao;

import by.bsuir.filmography.config.WebConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
public class FilmDAOImplTest {
    @Autowired
    private FilmDAO filmDAO;

    @Test
    public void filmDAOShouldNotBeNull() {
        Assert.assertNotNull(filmDAO);
    }
    @Test
    public void findDirectorByIdShouldReturnNull() {
        Assert.assertNull(filmDAO.findDirectorById(-1));
    }
    @Test
    public void findDirectorByIdShouldReturnADirector() {
        Assert.assertNotNull(filmDAO.findDirectorById(1));
    }
    @Test
    public void searchFilmByParametersShouldReturnListOfFilmsByDate() {
        LocalDate date = LocalDate.parse("2000-01-01");
        Assert.assertFalse(filmDAO.searchByParameters(-1, date).isEmpty());
    }
    @Test
    public void searchFilmByParametersShouldReturnListOfFilmsByDirectorId() {
        Assert.assertFalse(filmDAO.searchByParameters(2, null).isEmpty());
    }
    @Test
    public void searchFilmByParametersShouldReturnListOfFilmsByDateAndDirectorId() {
        LocalDate date = LocalDate.parse("2000-01-01");
        Assert.assertFalse(filmDAO.searchByParameters(0, date).isEmpty());
    }
}
