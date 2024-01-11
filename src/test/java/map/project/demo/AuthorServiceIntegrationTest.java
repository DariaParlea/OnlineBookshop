//package map.project.demo;
//import map.project.demo.entities.Author;
//import map.project.demo.service.AuthorService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//@SpringBootTest
//@Transactional
//public class AuthorServiceIntegrationTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private AuthorService authorService;
//
//    @Test
//    public void testGetAllAuthors() {
//        // Save test data to the database using TestEntityManager
//        Author author = new Author("John", "Doe");
//        entityManager.persist(author);
//
//        // Call the service method you want to test
//        List<Author> authors = authorService.getAllAuthors();
//
//        // Assert the results
//        assertThat(authors).hasSize(1);
//        assertThat(authors.get(0).getFirstName()).isEqualTo("John");
//        assertThat(authors.get(0).getLastName()).isEqualTo("Doe");
//    }
//
//    // Other test methods go here
//}
//
