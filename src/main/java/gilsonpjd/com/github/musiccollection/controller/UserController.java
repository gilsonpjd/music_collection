package gilsonpjd.com.github.musiccollection.controller;

import gilsonpjd.com.github.musiccollection.DTO.UserDto;
import gilsonpjd.com.github.musiccollection.model.User;
import gilsonpjd.com.github.musiccollection.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> UsersList() {
        List<UserDto> users = userService.UsersList();
        return ResponseEntity
                .ok(users);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> UserById(@PathVariable Integer id) {
        return ResponseEntity
                .ok(userService.UserById(id));
    }
    @PostMapping
    public ResponseEntity<UserDto> CreatedUser(@RequestBody User user) {
        return new ResponseEntity<>(
                userService.CreatedUser(user), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> UpdateUser(@PathVariable Integer id, @RequestBody User user) {
        return new ResponseEntity<>
                (userService.UpdateUser(id, user), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> DeleteUser(@PathVariable Integer id) {
        userService.DeleteUser(id);
        return ResponseEntity.noContent().build();
    }

}





