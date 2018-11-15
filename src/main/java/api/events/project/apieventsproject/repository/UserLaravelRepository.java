package api.events.project.apieventsproject.repository;


import api.events.project.apieventsproject.entity.UserLaravel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLaravelRepository extends JpaRepository<UserLaravel, Long> {
}
