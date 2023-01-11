package juicenetcafe.usermanagement;

import juicenetcafe.usermanagement.entities.Role;
import juicenetcafe.usermanagement.entities.User;
import juicenetcafe.usermanagement.services.RoleService;
import juicenetcafe.usermanagement.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(RoleService roleService, UserService userService) {
        return args -> {
            roleService.create(new Role(null, "ADMIN"));
            roleService.create(new Role(null, "GUEST"));

            userService.create(new User(null, "Admin", "admin", "admin@email.com", "airliner", new ArrayList<>()));
            userService.create(new User(null, "John Deere", "johndeere", "johndeere@email.com", "airliner", new ArrayList<>()));

            userService.assignRoleToUser("admin", "ADMIN");
            userService.assignRoleToUser("johndeere", "GUEST");
        };
    }
}
