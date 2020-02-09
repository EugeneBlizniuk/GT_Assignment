package by.bsuir.filmography.service;

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
public class ServiceFilmImplTest {
    @Autowired
    private FilmService filmService;
    @Test
    public void filmServiceShouldNotBeNull() {
        Assert.assertNotNull(filmService);
    }
    @Test
    public void findDirectorByIdShouldReturnNull() {
        Assert.assertNull(filmService.findDirectorById(-1));
    }
    @Test
    public void findDirectorByIdShouldNotReturnADirector() {
        Assert.assertNotNull(filmService.findDirectorById(1));
    }
    @Test
    public void searchFilmByParametersShouldReturnListOfFilmsByDate() {
        LocalDate date = LocalDate.parse("2000-01-01");
        Assert.assertNotNull(filmService.searchFilmByParameters(-1, date));
    }
    @Test
    public void searchFilmByParametersShouldReturnListOfFilmsByDirectorId() {
        Assert.assertNotNull(filmService.searchFilmByParameters(2, null));
    }
    @Test
    public void searchFilmByParametersShouldReturnListOfFilmsByDateAndDirectorId() {
        LocalDate date = LocalDate.parse("2000-01-01");
        Assert.assertNotNull(filmService.searchFilmByParameters(0, date));
    }
}
