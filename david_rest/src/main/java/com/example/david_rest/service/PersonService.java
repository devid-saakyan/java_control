package com.example.david_rest.service;

import com.example.david_rest.Entity.PersonEntity;
import java.util.List;

public interface PersonService {

    PersonEntity create(PersonEntity person);

    List<PersonEntity> readAll();

    PersonEntity read(int id);

    boolean update(PersonEntity person, int id);

    boolean delete(int id);
}
