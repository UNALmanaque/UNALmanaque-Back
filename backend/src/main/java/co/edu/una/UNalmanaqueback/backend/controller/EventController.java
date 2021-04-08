package co.edu.una.UNalmanaqueback.backend.controller;

import co.edu.una.UNalmanaqueback.backend.model.Event;
import co.edu.una.UNalmanaqueback.backend.repository.EventRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class EventController {
    @Autowired
    private EventRepository eventRepository;
    @PostMapping(path = "/event")
    public @ResponseBody String addNewEvent(@RequestParam Integer week, @RequestParam Integer rep, @RequestParam String name, @RequestParam String color, @RequestParam Integer priority) {
        Event newEvent = new Event();
        newEvent.setEventWeek(week);
        newEvent.setEventRep(rep);
        newEvent.setEventName(name);
        newEvent.setEventColor(color);
        newEvent.setEventPriority(priority);
        eventRepository.save(newEvent);
        return "Saved";
    }

    @GetMapping(path = "/event")
    public @ResponseBody Iterable<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}
