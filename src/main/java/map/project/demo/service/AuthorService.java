package map.project.demo.service;

import map.project.demo.entities.Author;
import map.project.demo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(int authorId) {
        return authorRepository.findById(authorId);
    }

    public Author getAuthorByName(String firstName, String lastName) {
        return authorRepository.findByFirstNameAndLastName(firstName, lastName);
    }


    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void deleteAuthor(int authorId) {
        authorRepository.deleteById(authorId);
    }
}
