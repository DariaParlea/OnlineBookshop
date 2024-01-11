package map.project.demo.entities;

import jakarta.persistence.*;
@Entity
@AttributeOverride(name = "id", column = @Column(name = "authorId"))
public class Author extends Person {



    protected Author(){}

    public Author(String firstName, String lastName, String birthDate, String address, int author_id) {
        super( firstName, lastName, birthDate, address);
        this.id = author_id;
    }



    public int getAuthorId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + this.id +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                '}';
    }
}
