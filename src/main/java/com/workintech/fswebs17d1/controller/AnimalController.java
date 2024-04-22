package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class AnimalController {
    private Map<Integer, Animal> animals = new HashMap<>();

    @Value("${java-fulltime}")
    private String courseName;
    @Value("${ilsu sunal}")
    private String fullName;

    @PostConstruct
    public void load(){
        this.animals = new HashMap<>();
        this.animals.put(1, new Animal(1, "maymun"));
    }
    @GetMapping("/animal")
    public List<Animal> findAll(){
        return animals.values().stream().toList();
    }
    @GetMapping("/animal/{id}")
    public Animal findAnimal(@PathVariable int id){
        Animal animal = animals.get(id);
        return animal;
    }
    @PostMapping("/animal")
    public Animal createAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(), animal);
        return animal;
    }
    @PutMapping("/animal/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal){
        animals.put(id, new Animal(id, animal.getName()));
        return animals.get(id);
    }
    @DeleteMapping("/animal/{id}")
    public Animal deleteAnimal(@PathVariable int id){
        Animal animal = animals.get(id);
        animals.remove(id, animal);
        return animal;
    }



}
