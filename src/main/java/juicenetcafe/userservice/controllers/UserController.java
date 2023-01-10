package juicenetcafe.userservice.controllers;

import juicenetcafe.userservice.entities.User;
import juicenetcafe.userservice.pojos.RoleToUser;
import juicenetcafe.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> index() {
        return ResponseEntity.ok().body(userService.index());
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @PostMapping("/role/add")
    public ResponseEntity<?> addRoleToUser(@RequestBody @NotNull RoleToUser form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> details(@PathVariable("username") String username) throws ResponseStatusException {
        return ResponseEntity.ok().body(userService.details(username));
    }
}
