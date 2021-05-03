package by.gstu.library.service;

import by.gstu.library.model.Book;
import by.gstu.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService  {
    @Autowired
    private BookRepository bookRepository;

    public Book get(long id) {
        return bookRepository.getOne(id);
    }

    public Page<Book> getAllByGenreAndAuthor(String genre, String author, int pageNumber,
                                             int pageSize, String sortedField, Sort.Direction direction) {
        return bookRepository.findAllByGenreGenreContainingAndAuthorFullNameContaining(genre, author,
                PageRequest.of(pageNumber, pageSize, direction, sortedField));
    }
}
