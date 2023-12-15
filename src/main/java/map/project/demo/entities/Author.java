package map.project.demo.entities;

//import javax.persistence.*;
import jakarta.persistence.*;
@Entity
@AttributeOverride(name = "id", column = @Column(name = "authorId"))
public class Author extends Person {



    protected Author(){}

    public Author(String firstName, String lastName, String birthDate, String address, int authorId) {
        super( firstName, lastName, birthDate, address);
        this.id = authorId;
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
