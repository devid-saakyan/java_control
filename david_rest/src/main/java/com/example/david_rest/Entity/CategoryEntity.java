package com.example.david_rest.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class CategoryEntity {
    @Id
    private long id;
    private String name;

    public void set_id(Long id){this.id = id;}
    public Long get_id(){return id;}

    public void set_name(String name) {this.name = name;}
    public String get_name(){return name;}

}
