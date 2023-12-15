package map.project.demo.controllers;

import map.project.demo.entities.Books;
import map.project.demo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Books")
public class BooksController {

    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/{BookId}")
    public Books getBookById(@PathVariable int BookId) {
        return booksService.getBookById(BookId).orElse(null);
    }

    @PostMapping
    public Books saveBook(@RequestBody Books book) {
        return booksService.saveBook(book);
    }

    @DeleteMapping("/{BookId}")
    public void deleteBook(@PathVariable int BookId) {
        booksService.deleteBook(BookId);
    }

}
