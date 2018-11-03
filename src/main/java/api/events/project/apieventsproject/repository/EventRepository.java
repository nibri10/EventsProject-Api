package api.events.project.apieventsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import api.events.project.apieventsproject.entity.Event;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository  extends JpaRepository <Event,Long> {

}
