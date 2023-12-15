package map.project.demo.service;

import map.project.demo.entities.Books;
import map.project.demo.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    public Optional<Books> getBookById(int bookId) {
        return booksRepository.findById(bookId);
    }

    public Books saveBook(Books book) {
        return booksRepository.save(book);
    }

    public void deleteBook(int bookId) {
        booksRepository.deleteById(bookId);
    }

}
