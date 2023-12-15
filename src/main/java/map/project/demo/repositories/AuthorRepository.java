package map.project.demo.repositories;
import map.project.demo.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
    Author findByFirstNameAndLastName(String firstName, String lastName);

}
