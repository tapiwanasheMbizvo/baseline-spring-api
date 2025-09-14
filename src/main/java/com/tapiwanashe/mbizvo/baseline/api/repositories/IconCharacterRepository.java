package com.tapiwanashe.mbizvo.baseline.api.repositories;

import com.tapiwanashe.mbizvo.baseline.api.entity.IconicCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IconCharacterRepository extends JpaRepository<IconicCharacter, Long> {

    Optional<IconicCharacter> findByEmail(String email);
}
