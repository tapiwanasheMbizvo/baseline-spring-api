package com.tapiwanashe.mbizvo.baseline.api.services.impl;

import com.tapiwanashe.mbizvo.baseline.api.repositories.IconCharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IconCharactersServiceTest {

    @Mock
    private IconCharacterRepository iconCharacterRepository;

    @InjectMocks
    private IconCharactersService iconCharactersService;
    @Test
    void create() {
        assertNotNull(iconCharactersService);
    }
}