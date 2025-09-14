package com.tapiwanashe.mbizvo.baseline.api.services.impl;

import com.tapiwanashe.mbizvo.baseline.api.entity.IconicCharacter;
import com.tapiwanashe.mbizvo.baseline.api.exceptions.EmailAlreadyTakenException;
import com.tapiwanashe.mbizvo.baseline.api.repositories.IconCharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IconCharactersService {

    private final IconCharacterRepository crudRepository;


    public IconicCharacter create(IconicCharacter character) {

        if (crudRepository.findByEmail(character.getEmail()).isPresent()) {

            throw  new EmailAlreadyTakenException("Email already exists");
        }
        return crudRepository.save(character);
    }

    public List<IconicCharacter> findAll() {
        return crudRepository.findAll();
    }

    public IconicCharacter findById(Long id) {
        return crudRepository.findById(id).orElse(null);
    }


}
