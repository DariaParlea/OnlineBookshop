package map.project.demo.entities.Patterns.Factory;

import map.project.demo.entities.Author;
import map.project.demo.entities.Clients;

public class PersonFactory {
    public Author createAuthor(int id, String firstName, String lastName, String birthDate, String address) {
        return new Author(firstName, lastName, birthDate, address, id);
    }
    public Clients createClient( String firstName, String lastName, String birthDate, String address,int id, String email) {
        return new Clients( firstName, lastName, birthDate, address,id, email);
    }
}
