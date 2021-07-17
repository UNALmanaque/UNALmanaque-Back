package co.edu.una.UNalmanaqueback.backend.controller;

import co.edu.una.UNalmanaqueback.backend.model.Event;
import co.edu.una.UNalmanaqueback.backend.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(path = "/even/find/sorted/{userId}")
    public @ResponseBody Iterable<Event> getSortedEventsByUser(@PathVariable(value = "userId") Integer userId) {
        List <Event> events = new ArrayList<Event>();
        getEventsByUser(userId).forEach(events::add);
        events.sort(Comparator.comparing(Event::getState));
        return events;

    }
    @DeleteMapping(path = "/event/delete/{eventId}")
    public @ResponseBody void deleteEventById(@PathVariable(value = "eventId") Integer eventId){
        eventRepository.deleteById(eventId);
    }
    @PutMapping(path = "/event/update/{eventId}")
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
                    return eventRepository.save(event);
                })
                .orElseGet(() -> {
                    newEvent.setEventId(eventId);
                    return eventRepository.save(newEvent);
                });
    }
}
