package api.events.project.apieventsproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="medical_records")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class MedicalRecord implements Serializable {

    @Id @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank @Getter @Setter
    private String name;

    @NotBlank @Getter @Setter
    private String placeBirth;


    @NotNull @Getter @Setter  @JsonFormat(pattern="yyyy-MM-dd")
    private Date birthdate;

    @NotBlank @Getter @Setter
    private String age;

    @NotNull @Getter @Setter
    private Integer civilStatus;

    @NotNull @Getter @Setter
    private  Integer gender;

    @NotBlank @Getter @Setter
    private String cns;

    @NotNull @Getter @Setter
    private String provenance;

    @NotBlank @Getter @Setter
    private String motherName;

    @NotNull @Getter @Setter
    private  String phone;

    @NotNull @Getter @Setter
    private  String phoneSecondary;

    @NotNull @Getter @Setter
    private  String professional;

    @NotNull @Getter @Setter
    private  String postalCode;

    @NotNull @Getter @Setter
    private  String addressName;

    @NotNull @Getter @Setter
    private  String addressNeighborhood;

    @NotNull @Getter @Setter
    private  String addressNumber;

    @Getter @Setter
    private  String addressSupplement;

    @NotNull @Getter @Setter
    private  String addressState;

    @NotNull @Getter @Setter
    private  String addressCity;

    @NotNull @Getter @Setter
    private  String addressCountry;

    @NotNull @Getter @Setter
    private  String symptoms;


    @NotNull @Getter @Setter
    private  String complaints;


    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Getter @Setter
    private Date createdAt;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Getter @Setter
    private Date updatedAt;

}
