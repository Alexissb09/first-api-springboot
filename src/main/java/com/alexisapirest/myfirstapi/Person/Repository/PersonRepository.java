package com.alexisapirest.myfirstapi.Person.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alexisapirest.myfirstapi.Person.Model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}