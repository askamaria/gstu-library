package by.gstu.library.controller;

import by.gstu.library.model.Book;
import by.gstu.library.model.Paginator;
import by.gstu.library.service.BookService;
import by.gstu.library.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private BookService bookService;
    @Autowired
    private GenreService genreService;

    @GetMapping(value = {"/", "/home"})
    public String booksPaging(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "6") Integer pageSize,
                              @RequestParam(defaultValue = "") String genre,
                              @RequestParam(defaultValue = "") String author,
                              @RequestParam(defaultValue = "id") String sortedBy,
                              Model model) {
        Page<Book> booksPage = bookService.getAllByGenreAndAuthor(genre, author,
                page - 1, pageSize, sortedBy, Sort.Direction.ASC);
        Paginator<Book> paginator = new Paginator<>(booksPage);
        model.addAttribute("paginator", paginator);
        model.addAttribute("books", booksPage.getContent());
        model.addAttribute("genres", genreService.getAll());
        model.addAttribute("selectedGenre", genre);
        model.addAttribute("sortedBy", sortedBy);
        model.addAttribute("author", author);
        return "index";
    }

    @GetMapping(value = {"/books/{bookId}"})
    public String getBook(@PathVariable long bookId, Model model) {
        Book book = bookService.get(bookId);
        model.addAttribute("book", book);
        return "book-description";
    }
}
