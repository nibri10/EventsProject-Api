package api.events.project.apieventsproject.repository;

import api.events.project.apieventsproject.entity.EventRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRegistrationRepository extends JpaRepository<EventRegistration,Long> {

}
