package it.linksmt.academy.micro.course.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table( name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank( message = "Code is mandatory")
    @Size(min = 0, max = 50)
    private String code;

    private String description;

    @Column(name="num_days")
    private Integer numDays;

    @Column(name = "max_num_attendees")
    private Integer maxNumAttendees;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumDays() {
        return numDays;
    }

    public void setNumDays(Integer numDays) {
        this.numDays = numDays;
    }

    public Integer getMaxNumAttendees() {
        return maxNumAttendees;
    }

    public void setMaxNumAttendees(Integer maxNumAttendees) {
        this.maxNumAttendees = maxNumAttendees;
    }
}
