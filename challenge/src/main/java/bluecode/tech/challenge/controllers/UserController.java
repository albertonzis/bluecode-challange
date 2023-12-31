package bluecode.tech.challenge.controllers;

import bluecode.tech.challenge.models.User;
import bluecode.tech.challenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
