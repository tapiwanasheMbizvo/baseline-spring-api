package com.tapiwanashe.mbizvo.baseline.api.controllers;

import com.tapiwanashe.mbizvo.baseline.api.dto.ApiResponse;
import com.tapiwanashe.mbizvo.baseline.api.entity.IconicCharacter;
import com.tapiwanashe.mbizvo.baseline.api.services.impl.IconCharactersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/characters")
@RequiredArgsConstructor
public class IconicCharactersController {
    private final IconCharactersService iconCharactersService;


    @GetMapping
    public ApiResponse<?> findAll() {

        log.atInfo()
                .setMessage("findAll started")
                .log();
        return ApiResponse.builder()
                .data(iconCharactersService.findAll())
                .timestamp(LocalDateTime.now())
                .message("characters")
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<?> findById(@PathVariable Long id) {
        return ApiResponse.builder()
                .data(iconCharactersService.findById(id))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @PostMapping
    public ApiResponse<?> save(@RequestBody IconicCharacter iconicCharacter) {

        return
                ApiResponse.builder()
                        .data(iconCharactersService.create(iconicCharacter))
                        .timestamp(LocalDateTime.now())
                        .build();
    }
}
