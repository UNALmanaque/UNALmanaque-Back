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
    @Column
    private Date eventStartDate;
    @Column
    private Date eventEndDate;
    @Column
    private Boolean eventRep;
    @Column
    private String eventName;
    @Column
    private String eventColor;
    @Column
    private Integer eventPriority;
    @Column
    private Integer eventDaily;
    @Column
    private Integer eventWeek;
    @Column
    private Integer state;
    @Column
    private Integer curStreak;
    @Column
    private Integer maxStreak;

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
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getEventColor() {
        return eventColor;
    }
    public void setEventColor(String eventColor) {
        this.eventColor = eventColor;
    }
    public Integer getEventPriority() {
        return eventPriority;
    }
    public void setEventPriority(Integer eventPriority) {
        this.eventPriority = eventPriority;
    }
    public Integer getEventDaily() {
        return eventDaily;
    }
    public void setEventDaily(Integer eventDaily) {
        this.eventDaily = eventDaily;
    }
    public Integer getEventWeek() {
        return eventWeek;
    }
    public void setEventWeek(Integer eventWeek) {
        this.eventWeek = eventWeek;
    }
    public void setState(Integer state) { this.state = state; }
    public Integer getState() {return this.state; }
    public void setCurStreak(Integer curStreak) { this.curStreak = curStreak; }
    public Integer getCurStreak() { return this.curStreak; }
    public void setMaxStreak(Integer maxStreak) {this.maxStreak = maxStreak; }
    public Integer getMaxStreak() { return this.maxStreak; }

    //Foreign Keys
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
