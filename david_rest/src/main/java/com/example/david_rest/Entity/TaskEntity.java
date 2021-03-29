package com.example.david_rest.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class TaskEntity {
    PersonEntity personEntity = new PersonEntity();
    CategoryEntity categoryEntity = new CategoryEntity();
    @Id
    private long id;
    private String name;
    private String description;
    private LocalDate done_date;
    private Boolean status;
    public Long get_person(){return personEntity.getId();}
    public String get_category(){return categoryEntity.get_name();}
}
