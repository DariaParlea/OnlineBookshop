package map.project.demo.entities;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import jakarta.persistence.*;


@Entity
@AttributeOverride(name = "id", column = @Column(name = "clientId"))
public class Clients extends Person {


    private String email;

    protected Clients(){

    }

    public Clients(String firstName, String lastName, String birthDate, String address,int clientId, String email) {
        super(firstName, lastName, birthDate, address);
        this.id = clientId;
        this.email = email;
    }




    public int getClientId() {
        return this.id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
