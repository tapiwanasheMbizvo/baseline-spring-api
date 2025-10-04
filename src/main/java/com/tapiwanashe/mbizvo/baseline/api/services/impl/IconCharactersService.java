package com.tapiwanashe.mbizvo.baseline.api.services.impl;

import com.tapiwanashe.mbizvo.baseline.api.entity.IconicCharacter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IconCharactersService {

    private final JpaRepository<IconicCharacter, Long> crudRepository;


    public IconicCharacter create(IconicCharacter character) {

        return crudRepository.save(character);
    }

    public List<IconicCharacter> findAll() {
        return crudRepository.findAll();
    }

    public IconicCharacter findById(Long id) {
        return crudRepository.findById(id).orElse(null);
    }


}
