package fr.bracchi.myApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.bracchi.myApi.model.Animal;
import fr.bracchi.myApi.service.AnimalService;

@RestController
public class AnimalController {

    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animals")
    public List<Animal> getAllAnimal() {
        return animalService.getAllAnimal();
    }

    @GetMapping("/animal")
    public Animal getAnimal(@RequestParam int id) {
        return animalService.getAnimal(id);
    }

    @PostMapping("/animal")
    public Animal createAnimal(@RequestBody AnimalResquest body) {
        Animal animal = animalService.createAnimal(body.getName(), body.getType(), body.getWeight());
        return animal;
    }
    
    @PutMapping("/animal")
    public Animal updateAnimal(@RequestParam int id, @RequestBody AnimalResquest body) {
        String name = body.getName();
        String type = body.getType();
        int weight = body.getWeight();

        Animal animal = animalService.updateAnimal(id, name, type, weight);
        return animal;
    }

    @DeleteMapping("/animal")
    public Animal deleteAnimal(@RequestParam int id) {
        Animal animal = animalService.deleteAnimal(id);
        return animal;
    }
}
