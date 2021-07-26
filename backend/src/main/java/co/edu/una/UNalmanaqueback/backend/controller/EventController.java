package co.edu.una.UNalmanaqueback.backend.controller;

import co.edu.una.UNalmanaqueback.backend.model.Event;
import co.edu.una.UNalmanaqueback.backend.repository.EventRepository;
import jdk.vm.ci.meta.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class EventController {
    @Autowired
    private EventRepository eventRepository;
    @PostMapping(path = "/event")
    @ResponseBody
    public String addNewEvent(@RequestBody Event event) {
        eventRepository.save(event);
        return "saved";
    }
    @GetMapping(path = "/event")
    public @ResponseBody Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    @GetMapping(path = "/event/find/{userId}")
    public @ResponseBody Iterable<Event> getEventsByUser(@PathVariable(value = "userId") Integer userId) {
        return eventRepository.getEventsByUser(userId);
    }

    @GetMapping(path = "/event/find/sorted/{userId}")
    public @ResponseBody Iterable<Event> getSortedEventsByUser(@PathVariable(value = "userId") Integer userId) {
        List <Event> events = new ArrayList<>();
        getEventsByUser(userId).forEach(events::add);
        events.sort(Comparator.comparing(Event::getEventState));
        return events;
    }
    @DeleteMapping(path = "/event/delete/{eventId}")
    public @ResponseBody void deleteEventById(@PathVariable(value = "eventId") Integer eventId){
        eventRepository.deleteById(eventId);
    }

    @PatchMapping(path = "/event/update/{eventId}")
    Event updateEvent(@RequestBody Event newEvent, @PathVariable Integer eventId) {
        return eventRepository.findById(eventId)
                .map(event -> {
                    event.setEventName(newEvent.getEventName());
                    event.setEventStartDate(newEvent.getEventStartDate());
                    event.setEventEndDate(newEvent.getEventEndDate());
                    event.setEventRep(newEvent.getEventRep());
                    event.setCategory(newEvent.getCategory());
                    event.setEventColor(newEvent.getEventColor());
                    event.setUser(newEvent.getUser());
                    event.setEventDaily(newEvent.getEventDaily());
                    event.setEventWeek(newEvent.getEventWeek());
                    event.setEventPriority(newEvent.getEventPriority());
                    event.setEventState(newEvent.getEventState());
                    event.setEventCurStreak(newEvent.getEventCurStreak());
                    event.setEventMaxStreak(newEvent.getEventMaxStreak());
                    event.setEventDone(newEvent.getEventDone());
                    return eventRepository.save(event);
                })
                .orElseGet(() -> {
                    newEvent.setEventId(eventId);
                    return eventRepository.save(newEvent);
                });
    }

    @PatchMapping(path = "/event/update/streak/{eventId}")
    void updateEventStreak(@RequestBody Event updatedEvent, @PathVariable Integer eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(NullPointerException::new);
        event.setEventCurStreak(updatedEvent.getEventCurStreak());
        event.setEventMaxStreak(updatedEvent.getEventMaxStreak());
        event.setEventState(updatedEvent.getEventState());
        eventRepository.save(event);
    }
    @PatchMapping(path = "/event/update/state/{eventId}")
    void updateEventState(@PathVariable Integer eventId) {
        Event e = eventRepository.findById(eventId).orElseThrow(NullPointerException::new);
        int state = 0;
        boolean done = e.getEventDone();
        Date today = Date.valueOf(LocalDate.now());
        System.out.println(today);
        System.out.println(e.getEventEndDate());
        if (today.before(e.getEventStartDate())) {
            state = 0;
        } else if (!(today.before(e.getEventStartDate()) || today.after(e.getEventEndDate()))){
            if(done) state = 2;
            else state = 1;
        } else {
            if(done) state = 2;
            else state = 3;
        }
        e.setEventState(state);
        System.out.println(state);
        eventRepository.save(e);
    }
}
