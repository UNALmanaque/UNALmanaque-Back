package co.edu.una.UNalmanaqueback.backend.controller;

import co.edu.una.UNalmanaqueback.backend.model.Event;
import co.edu.una.UNalmanaqueback.backend.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
