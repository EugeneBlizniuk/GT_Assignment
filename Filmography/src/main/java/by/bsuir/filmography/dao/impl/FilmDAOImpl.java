package by.bsuir.filmography.dao.impl;

import by.bsuir.filmography.dao.FilmDAO;
import by.bsuir.filmography.model.Director;
import by.bsuir.filmography.model.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public class FilmDAOImpl implements FilmDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Director> allDirectors() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Director ").list();
    }
    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Film> allFilms() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Film").list();
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Film> getFilmByLocalDate(LocalDate date) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Film where releaseDate =: date");
        query.setParameter("date", date);
        return query.list();
    }
    @Transactional
    @Override
    public Director findDirectorById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Director.class, id);
    }
    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<Film> findFilmByDirector(Director director) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Film where director.id = :id");
        query.setParameter("id", director.getId());
        return query.list();
    }
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Film> searchByParameters(int id, LocalDate date) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        if(date != null && id >= 0) {
            query = session.createQuery("from Film where releaseDate >= :date and director.id = :id");
            query.setParameter("date", date);
            query.setParameter("id", id);
            return query.list();
        } else if(date != null) {
            query = session.createQuery("from Film where releaseDate >= :date");
            query.setParameter("date", date);
            return query.list();
        } else if(id >= 0) {
            query = session.createQuery("from Film where director.id = :id");
            query.setParameter("id", id);
            return query.list();
        }
        return null;
    }
}
