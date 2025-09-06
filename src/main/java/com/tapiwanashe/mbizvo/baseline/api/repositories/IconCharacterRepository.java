package com.tapiwanashe.mbizvo.baseline.api.repositories;

import com.tapiwanashe.mbizvo.baseline.api.entity.IconicCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IconCharacterRepository extends JpaRepository<IconicCharacter, Long> {
}
