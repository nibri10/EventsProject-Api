package api.events.project.apieventsproject.controller;

import api.events.project.apieventsproject.Exception.ResourceNotFoundException;
import api.events.project.apieventsproject.entity.User;
import api.events.project.apieventsproject.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Api(value = "/api",description = "User ")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @ApiOperation(value = "GET ALL USERS")
    @GetMapping("/user")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    @ApiOperation(value = "CREATE USER")
    @PostMapping("/user/create")
    public User createNote(@Valid @RequestBody User user){

        return userRepository.save(user);
    }


    @ApiOperation(value = "GET SINGLE USER")
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable(value = "id") Long user) {
        return userRepository.findById(user)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", user));
    }

    // UPDATE USER
    @ApiOperation(value = "UPDATE USER")
    @PutMapping("/update/user/{id}")
    public User UpdateUser(@PathVariable(value = "id") Long id, @Validated @RequestBody User userDetails){
        User note = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id",id));
        note.setName(userDetails.getName());
        note.setEmail(userDetails.getEmail());
        note.setLevel(userDetails.getLevel());
        note.setPassword(userDetails.getPassword());
        User updatedNote = userRepository.save(note);
        return updatedNote;
    }

    @ApiOperation(value = "DELETE USER")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> DeleteUser(@PathVariable(value = "id") Long Id) {
        User user = userRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("User", "id",Id));
        userRepository.delete(user);
        return ResponseEntity.ok().build();

    }
}
