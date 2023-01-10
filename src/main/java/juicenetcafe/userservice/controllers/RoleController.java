package juicenetcafe.userservice.controllers;

import juicenetcafe.userservice.entities.Role;
import juicenetcafe.userservice.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> index() {
        return ResponseEntity.ok().body(roleService.index());
    }

    @PostMapping
    public ResponseEntity<Role> create(@Valid @RequestBody Role role) {
        return new ResponseEntity<>(roleService.create(role), HttpStatus.CREATED);
    }
}
