package co.edu.una.UNalmanaqueback.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Category", schema = "unalmanaquedb")
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer categoryId;
    private String categoryName;

    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    //Foreign Keys
    @JsonIgnore
    @OneToMany (mappedBy = "category")
    private List<Event> events;

}
