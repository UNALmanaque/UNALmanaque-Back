package co.edu.una.UNalmanaqueback.backend.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;
import javax.persistence.ElementCollection;

@Entity
@Table(name = "Event", schema = "unalmanaquedb")
public class Event {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer eventId;
    @Column
    private Date eventStartDate;
    @Column
    private Date eventLastDate;
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
    private Integer eventState;
    @Column
    private Integer eventCurStreak;
    @Column
    private Integer eventMaxStreak;
    @Column
    private Integer eventDays;
    @Column
    private Boolean eventDone;
    @ElementCollection
    @Column
    private List <Date> eventCompletionList;

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
    public  void setEventDone(Boolean eventDone){
        this.eventDone = eventDone;
    }
    public Boolean getEventDone(){
        return this.eventDone;
    }
    public void setEventState(Integer eventState) {
        this.eventState = eventState;
    }
    public Integer getEventState() {
        return this.eventState;
    }
    public void setEventCurStreak(Integer eventCurStreak) {
        this.eventCurStreak = eventCurStreak;
    }
    public Integer getEventCurStreak() {
        return this.eventCurStreak;
    }
    public void setEventMaxStreak(Integer eventMaxStreak) {
        this.eventMaxStreak = eventMaxStreak;
    }
    public Integer getEventMaxStreak() {
        return this.eventMaxStreak;
    }
    public Date getEventLastDate() {
        return eventLastDate;
    }
    public void setEventLastDate(Date eventLastDate) {
        this.eventLastDate = eventLastDate;
    }
    public Integer getEventDays() {
        return eventDays;
    }
    public void setEventDays(Integer eventDays) {
        this.eventDays = eventDays;
    }
    public List<Date> getEventCompletionList() {
        return eventCompletionList;
    }
    public void setEventCompletionList(Date dateCompleted) {
        this.eventCompletionList.add(dateCompleted);
    }
    //Foreign Keys
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
