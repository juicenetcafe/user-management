package juicenetcafe.usermanagement.repositories;

import juicenetcafe.usermanagement.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
