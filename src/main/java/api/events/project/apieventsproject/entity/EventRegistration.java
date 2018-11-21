package api.events.project.apieventsproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="userRegistrations")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class EventRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long register_id;

    private long event_id_event;
    private long user_id_user;



    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getRegister_id() {
        return register_id;
    }

    public void setRegister_id(long register_id) {
        this.register_id = register_id;
    }

    public long getEvent_id_event() {
        return event_id_event;
    }

    public void setEvent_id_event(long event_id_event) {
        this.event_id_event = event_id_event;
    }

    public long getUser_id_user() {
        return user_id_user;
    }

    public void setUser_id_user(long user_id_user) {
        this.user_id_user = user_id_user;
    }
}
