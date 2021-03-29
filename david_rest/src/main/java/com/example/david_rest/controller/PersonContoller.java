package com.example.david_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.david_rest.service.PersonService;

@RestController
@RequestMapping("message")
public class PersonContoller {
    private final Person personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "/persons")
    public ResponseEntity<?> create(@RequestBody PersonContoller person) {
        PersonContoller newPerson = personService.create(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @GetMapping(value = "/persons")
    public ResponseEntity<List<PersonContoller>> read() {
        final List<PersonContoller> persons = personService.readAll();
        return persons != null && !persons.isEmpty() ? new ResponseEntity<>(persons, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/persons/{id}")
    public ResponseEntity<PersonContoller> read(@PathVariable(name = "id") int id) {
        final PersonContoller person = personService.read(id);
        return person != null ? new ResponseEntity<>(person, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping(value = "/persons/{id}")
    public ResponseEntity<PersonContoller> put(@PathVariable(name = "id") int id, @RequestBody PersonContoller newPerson) {

        //Если успешно обновлили данные
        if (personService.update(newPerson, id)) {
            //id персоны чтоб отдавался
            PersonContoller newPersonWithId = personService.read(id);
            return new ResponseEntity<>(newPersonWithId, HttpStatus.OK);
        }
        //Если не получилось обновить данные
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping(value = "/persons/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final PersonContoller person = personService.read(id);
        //Если есть такой пользователь
        if (person != null) {
            personService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        //Если такого пользователя нет
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
