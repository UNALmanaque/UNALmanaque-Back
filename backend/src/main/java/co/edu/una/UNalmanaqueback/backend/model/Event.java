package co.edu.una.UNalmanaqueback.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Event", schema = "unalmanaquedb")
public class Event {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer eventId;
    private Date eventStartDate;
    private Date eventEndDate;
    private Boolean eventRep;
    private String eventName;

    public Integer getEventId() {
        return eventId;
    }
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
    public Date getEventStartDate() {
        return eventStartDate;
    }
    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }
    public Date getEventEndDate() {
        return eventEndDate;
    }
    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }
    public Boolean getEventRep() {
        return eventRep;
    }
    public void setEventRep(Boolean eventRep) {
        this.eventRep = eventRep;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    //Foreign Keys
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
