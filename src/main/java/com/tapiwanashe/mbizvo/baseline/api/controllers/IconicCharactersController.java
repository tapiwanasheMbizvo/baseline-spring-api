package com.tapiwanashe.mbizvo.baseline.api.controllers;

import com.tapiwanashe.mbizvo.baseline.api.dto.ApiResponse;
import com.tapiwanashe.mbizvo.baseline.api.entity.IconicCharacter;
import com.tapiwanashe.mbizvo.baseline.api.services.impl.IconCharactersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
@RequiredArgsConstructor
public class IconicCharactersController {
    private final IconCharactersService iconCharactersService;


    @GetMapping
    public ApiResponse<?> findAll() {

        return ApiResponse.builder()
                .data(iconCharactersService.findAll())
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<?> findById(@PathVariable Long id) {
        return ApiResponse.builder()
                .data(iconCharactersService.findById(id))
                .build();
    }

    @PostMapping
    public ApiResponse<?> save(@RequestBody IconicCharacter iconicCharacter) {

        return
                ApiResponse.builder()
                        .data(iconCharactersService.create(iconicCharacter))
                        .build();
    }
}
