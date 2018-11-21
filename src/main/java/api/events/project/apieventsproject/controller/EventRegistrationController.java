package api.events.project.apieventsproject.controller;

import api.events.project.apieventsproject.Exception.ResourceNotFoundException;
import api.events.project.apieventsproject.entity.EventRegistration;
import api.events.project.apieventsproject.repository.EventRegistrationRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Event Registration", description = "Register user registration in Event")
@RequestMapping("/api")
public class EventRegistrationController {
    @Autowired
    EventRegistrationRepository eventRegistrationRepository;

    @ApiOperation(value="GET ALL REGISTRATIONS")
    @GetMapping("/register")
    public List<EventRegistration> getAllNotes() {
        return eventRegistrationRepository.findAll();
    }


    @ApiOperation(value = "CREATE REGISTER")
    @PostMapping("/register")
    public EventRegistration create(@Validated @RequestBody EventRegistration eventRegistration) {
        return eventRegistrationRepository.save(eventRegistration);

    }
    @ApiOperation(value="GET SINGLE REGISTER")
    @GetMapping("/register/{id}")
    public EventRegistration getEventById(@PathVariable(value = "id") Long register) {
        return eventRegistrationRepository.findById(register)
                .orElseThrow(() -> new ResourceNotFoundException("Register", "id", register));
    }

    @ApiOperation(value = "DELETE REGISTER IN EVENT")
    @DeleteMapping("/register/{id}")
    public ResponseEntity<?> DeleteEvent(@PathVariable(value = "id") Long id){
        EventRegistration delete = eventRegistrationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Register:", "id",id));
        eventRegistrationRepository.delete(delete);

        return ResponseEntity.ok().build();
    }

}
