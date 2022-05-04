package com.example.swagger.controller;

import com.example.swagger.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    Map<Integer, Person> personMap = new HashMap<>();

    @PostMapping(path = "/create")
    public Map createPersonData(@RequestBody Person person) {
        personMap.put(person.getId(), person);
        return personMap;
    }

    @GetMapping("/getAll")
    public Map getAllPersonsData() {
        return personMap;
    }

    @PutMapping("/updatePerson")
    public Map updatePersonData(@RequestBody Person person) {
        List<Person> personList = new ArrayList<>(personMap.values());
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId() == person.getId()) {
                personMap.put(person.getId(), person);
            }
        }
        return personMap;
    }

    @DeleteMapping("/deletePerson/{id}")
    public String deletePersonData(@PathVariable Integer id) {
        List<Person> personList = new ArrayList<>(personMap.values());
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId() == id) {
                personMap.remove(id);
                return "delete Successfully";
            }

        }
        return "id not found";

    }
}
