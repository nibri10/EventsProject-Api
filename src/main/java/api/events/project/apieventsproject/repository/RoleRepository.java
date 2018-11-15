package api.events.project.apieventsproject.repository;


import api.events.project.apieventsproject.entity.Role;
import api.events.project.apieventsproject.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}