package by.bsuir.filmography.conroller;

import by.bsuir.filmography.model.Director;
import by.bsuir.filmography.model.Film;
import by.bsuir.filmography.service.FilmService;
import by.bsuir.filmography.service.convertaition.InputDataConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {
    private FilmService filmService;

    @Autowired
    public void setFilmService(FilmService filmService) {
        this.filmService = filmService;
    }
    @RequestMapping(value = "/show-all-tables", method = RequestMethod.GET)
    public ModelAndView showAllInformation() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allInformation");
        modelAndView.addObject("directors", filmService.allDirectors());
        modelAndView.addObject("films", filmService.allFilms());
        return modelAndView;
    }
    @RequestMapping(value = "/searching", method = RequestMethod.GET)
    public ModelAndView searchPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("searchPage");
        return modelAndView;
    }
    @RequestMapping(value = "/searching", method = RequestMethod.POST)
    public ModelAndView searchByParameters(@RequestParam("start_date")String date,
                                           @RequestParam("director_id")String stringID) {
        ModelAndView modelAndView = new ModelAndView();
        int id = InputDataConverter.convertID(stringID);
        LocalDate startDate = InputDataConverter.convertDate(date);
        Director director = filmService.findDirectorById(id);
        List<Film> films = filmService.searchFilmByParameters(id, startDate);
        modelAndView.addObject("director", director);
        modelAndView.addObject("films", films);
        modelAndView.setViewName("searchingResult");
        return modelAndView;
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcomePage");
        return modelAndView;
    }
}
