package com.lschaan.poc.jpa.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lschaan.poc.jpa.api.request.PetRequest;
import com.lschaan.poc.jpa.entity.Pet;
import com.lschaan.poc.jpa.exception.PetNotFoundException;
import com.lschaan.poc.jpa.repository.PetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    public Pet findById(Integer id) throws PetNotFoundException {
        return petRepository.findById(id).orElseThrow(PetNotFoundException::new);
    }

    public Pet create(PetRequest petRequest) {
        return petRepository.save(objectMapper.convertValue(petRequest, Pet.class));
    }

}
