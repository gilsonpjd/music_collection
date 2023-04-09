package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> UsersList() {
        List<User> users = userService.UsersList();
        return ResponseEntity
                .ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> UserById (@PathVariable Integer id){
        return ResponseEntity
                .ok(userService.UserById(id));
    }

    @PostMapping
    public ResponseEntity<User> CreatedUser (@RequestBody User user){
        return new ResponseEntity<>(
                userService.CreatedUser(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> UpdateUser(@PathVariable Integer id, @RequestBody User user){
        return new ResponseEntity<>
                (userService.UpdateUser(id, user), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")

    public ResponseEntity<User> DeleteUser (@PathVariable Integer id){
        userService.DeleteUser(id);
        return ResponseEntity.noContent().build();
    }

}





