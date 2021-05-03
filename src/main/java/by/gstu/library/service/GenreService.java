package by.gstu.library.service;

import by.gstu.library.model.Genre;
import by.gstu.library.repository.GenreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public Genre get(long id) {
        return genreRepository.getOne(id);
    }

    public List<Genre> getAll() {
        return genreRepository.findAll();
    }
}
