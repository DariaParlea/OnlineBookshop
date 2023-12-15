package map.project.demo.controllers;

import map.project.demo.entities.Author;
import map.project.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{AuthorID}")
    public Author getAuthorById(@PathVariable int AuthorID) {
        return authorService.getAuthorById(AuthorID).orElse(null);
    }

    @GetMapping("/FirstName, LastName")
    public Author getAuthorByName(@RequestParam String FirstName, @RequestParam String LastName) {
        return authorService.getAuthorByName(FirstName, LastName);
    }


    @PostMapping
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @DeleteMapping("/{AuthorID}")
    public void deleteAuthor(@PathVariable int AuthorID) {
        authorService.deleteAuthor(AuthorID);
    }
}
