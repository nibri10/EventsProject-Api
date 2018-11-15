package api.events.project.apieventsproject.controller;

import api.events.project.apieventsproject.Exception.ResourceNotFoundException;
import api.events.project.apieventsproject.entity.UserLaravel;
import api.events.project.apieventsproject.repository.UserLaravelRepository;
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
@RequestMapping("/api")
public class UserLaravelController {

    @Autowired
    UserLaravelRepository userLaravelRepository;


    @ApiOperation(value = "GET ALL USERS")
    @GetMapping("/user")
    public List<UserLaravel> getAllUser() {
        return  userLaravelRepository.findAll();
    }


    @ApiOperation(value = "CREATE USER")
    @PostMapping("/user")
    public UserLaravel createNote(@Valid @RequestBody UserLaravel user){

        return  userLaravelRepository.save(user);
    }


    @ApiOperation(value = "GET SINGLE USER")
    @GetMapping("/user/{id}")
    public UserLaravel getUserById(@PathVariable(value = "id") Long user) {
        return  userLaravelRepository.findById(user)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", user));
    }

    // UPDATE USER
    @ApiOperation(value = "UPDATE USER")
    @PutMapping("/user/{id}")
    public UserLaravel UpdateUser(@PathVariable(value = "id") Long id, @Validated @RequestBody UserLaravel userDetails){
        UserLaravel note =  userLaravelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id",id));
        note.setName(userDetails.getName());
        note.setEmail(userDetails.getEmail());
        note.setLevel(userDetails.getLevel());
        note.setPassword(userDetails.getPassword());
        UserLaravel updatedNote =  userLaravelRepository.save(note);
        return updatedNote;
    }

    @ApiOperation(value = "DELETE USER")
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> DeleteUser(@PathVariable(value = "id") Long id) {
        UserLaravel user =  userLaravelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id",id));
        userLaravelRepository.delete(user);
        return ResponseEntity.ok().build();

    }
}
