package api.events.project.apieventsproject.controller;

import api.events.project.apieventsproject.Exception.ResourceNotFoundException;
import api.events.project.apieventsproject.entity.Event;
import api.events.project.apieventsproject.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {
    @Autowired
    EventRepository eventRepository;

    // GET ALL Events
    @GetMapping("/event")
    public List<Event> getAllNotes() {
        return eventRepository.findAll();
    }

    // Create EVENTS
    @PostMapping("/event/create")
    public Event create(@Validated @RequestBody Event event) {
        return eventRepository.save(event);

    }

    // GET SINGLE EVENT
    @GetMapping("/event/{id}")
    public Event getEventById(@PathVariable(value = "id") Long event) {
        return eventRepository.findById(event)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", event));
    }

    // UPDATE EVENT
    @PutMapping("/event/edit/{id}")
    public Event UpdatedEvent(@PathVariable(value = "id") Long event, Event eventDetails) {
        Event update = eventRepository.findById(event).orElseThrow(() -> new ResourceNotFoundException("Event:", "id", event));
        update.setName(eventDetails.getName());
        update.setDescription(eventDetails.getDescription());
        update.setDate_inital(eventDetails.getDate_inital());
        update.setDate_finish(eventDetails.getDate_finish());
        update.setLocal(eventDetails.getLocal());
        update.setTime_initial(eventDetails.getTime_initial());
        update.setTime_expiration(eventDetails.getTime_expiration());
        update.setCity(eventDetails.getCity());
        update.setVancancies(eventDetails.getVancancies());
        update.setTarget_audience(eventDetails.getTarget_audience());
        update.setArquivo(eventDetails.getArquivo());
        Event updated_At = eventRepository.save(update);

        return updated_At;

    }
    // DELETE EVENT
    @DeleteMapping("/event/{id}")
    public ResponseEntity<?> DeleteEvent(@PathVariable(value = "id") Long id){
        Event delete = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event:", "id",id));
        eventRepository.delete(delete);

        return ResponseEntity.ok().build();
    }

}

