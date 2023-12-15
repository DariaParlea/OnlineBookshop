package map.project.demo.entities;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import jakarta.persistence.*;
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CategoryID;
    private String Type;


    public Category(int categoryID, String type) {
        CategoryID = categoryID;
        Type = type;
    }

    protected Category(){}
    //    public Category(int categoryID, String type) {
//        CategoryID = categoryID;
//        Type = type;
//    }

    public int getCategory_id() {
        return CategoryID;
    }

    public void setCategory_id(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    @Override
    public String toString() {
        return "Category{" +
                ", type='" + Type + '\'' +
                '}';
    }
}
