package co.edu.una.UNalmanaqueback.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "User", schema = "unalmanaquedb")
public class User {
    @Id
    private Integer userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private Date userBorn;

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public Date getUserBorn() {
        return userBorn;
    }
    public void setUserBorn(Date userBorn) {
        this.userBorn = userBorn;
    }
    //Foreign Keys
    @JsonIgnore
    @OneToMany (mappedBy = "user")
    private List<Event> users;
}
