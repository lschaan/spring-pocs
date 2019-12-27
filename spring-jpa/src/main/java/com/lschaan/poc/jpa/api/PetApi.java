package com.lschaan.poc.jpa.api;

import com.lschaan.poc.jpa.api.request.PetRequest;
import com.lschaan.poc.jpa.entity.Pet;
import com.lschaan.poc.jpa.exception.PetNotFoundException;
import com.lschaan.poc.jpa.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pet")
public class PetApi {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(petService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(
            @PathVariable Integer id) throws PetNotFoundException {
        return ResponseEntity.ok(petService.findById(id));
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createPet(
            @RequestBody PetRequest pet) {
        return ResponseEntity.ok(petService.create(pet));
    }
}
