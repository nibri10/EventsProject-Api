package api.events.project.apieventsproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="events")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;


    private Date date_initial;


    private Date date_finish;

    @NotBlank
    private String local;


    private String time_initial;


    private  String time_expiration;

    @NotBlank
    private String city;

    @NotNull
    private int vancancies;

    @NotBlank
    private String target_audience;

    @NotNull
    private  int arquivo;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_initial() {
        return date_initial;
    }

    public void setDate_initial(Date date_initial) {
        this.date_initial= date_initial;
    }

    public Date getDate_finish() {
        return date_finish;
    }

    public void setDate_finish(Date date_finish) {
        this.date_finish = date_finish;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTime_initial() {
        return time_initial;
    }

    public void setTime_initial(String time_initial) {
        this.time_initial = time_initial;
    }

    public String getTime_expiration() {
        return time_expiration;
    }

    public void setTime_expiration(String time_expiration) {
        this.time_expiration = time_expiration;
    }

    public int getVancancies() {
        return vancancies;
    }

    public void setVancancies(int vancancies) {
        this.vancancies = vancancies;
    }

    public String getTarget_audience() {
        return target_audience;
    }

    public void setTarget_audience(String target_audience) {
        this.target_audience = target_audience;
    }

    public int getArquivo() {
        return arquivo;
    }

    public void setArquivo(int arquivo) {
        this.arquivo = arquivo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

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
}
