package api.events.project.apieventsproject.controller;

import api.events.project.apieventsproject.Exception.ResourceNotFoundException;
import api.events.project.apieventsproject.entity.Event;
import api.events.project.apieventsproject.repository.EventRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "/api",description = "EVENTS")
@RequestMapping("/api")
public class EventController {
    @Autowired
    EventRepository eventRepository;


    @ApiOperation(value="GET ALL EVENTS")
    @GetMapping("/event")
    public List<Event> getAllNotes() {
        return eventRepository.findAll();
    }


    @ApiOperation(value = "CREATE EVENTS")
    @PostMapping("/event")
    public Event create(@Validated @RequestBody Event event) {
        return eventRepository.save(event);

    }


    @ApiOperation(value="GET SINGLE EVENT")
    @GetMapping("/event/{id}")
    public Event getEventById(@PathVariable(value = "id") Long event) {
        return eventRepository.findById(event)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", event));
    }

    @ApiOperation(value="EDIT EVENT")
    @PutMapping("/event/{id}")
    public Event UpdatedEvent(@PathVariable(value = "id") Long event, Event eventDetails) {
        Event update = eventRepository.findById(event).orElseThrow(() -> new ResourceNotFoundException("Event:", "id", event));
        update.setName(eventDetails.getName());
        update.setDescription(eventDetails.getDescription());
        update.setDate_initial(eventDetails.getDate_initial());
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
    @ApiOperation(value = "DELETE EVENT")
    @DeleteMapping("/event/{id}")
    public ResponseEntity<?> DeleteEvent(@PathVariable(value = "id") Long id){
        Event delete = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event:", "id",id));
        eventRepository.delete(delete);

        return ResponseEntity.ok().build();
    }

}

