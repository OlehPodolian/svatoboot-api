package oleg.podolyan.svatoapiboot.repository;

import oleg.podolyan.svatoapiboot.domain.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role save(Role role);

    Role findByName(String roleName);
}
