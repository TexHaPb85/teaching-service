package edu.study.teachingmoduleservice.controller.rest;

import edu.study.teachingmoduleservice.domain.user.User;
import edu.study.teachingmoduleservice.services.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/")
public class UserControllerREST {

    private final UserServiceImpl userService;

    public UserControllerREST(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public ResponseEntity<User> homePage(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user);
    }

    @PostMapping("/registration")
    public ResponseEntity<User> addUser(@RequestBody User user) {

        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }
}
