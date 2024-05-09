package com.alexisapirest.myfirstapi.Person.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alexisapirest.myfirstapi.Person.Model.Person;
import com.alexisapirest.myfirstapi.Person.Repository.PersonRepository;


@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getAllPersons(){
        return repository.findAll();
    }

    public ResponseEntity<?> getPersonById(Long id){
        Optional<Person> person = repository.findById(id);
        
        if (!person.isPresent()) {
            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("No se encontró la persona con el ID: " + id);
        }
        
        return ResponseEntity.ok(person.get());
    }

    public String createPerson(Person person) {
        repository.save(person);

        return "Person created";
    }

    public String deletePerson(Long id) {
        repository.deleteById(id);

        return "Person deleted";
    }

}
