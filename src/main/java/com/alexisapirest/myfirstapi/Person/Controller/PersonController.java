package com.alexisapirest.myfirstapi.Person.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexisapirest.myfirstapi.Person.Model.Person;
import com.alexisapirest.myfirstapi.Person.Service.PersonService;

@RestController()
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonById(@PathVariable Long id) {
        return service.getPersonById(id);
    }

    @GetMapping("/")
    public List<Person> getAllPersons() {
        return service.getAllPersons();
    }

    @PostMapping("/")
    public String createPerson(@RequestBody Person person) {
        return service.createPerson(person);
    }

    @DeleteMapping("/")
    public String deletePerson(@PathVariable Long id) {
        return service.deletePerson(id);
    }
}
