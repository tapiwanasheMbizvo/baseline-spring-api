package com.tapiwanashe.mbizvo.baseline.api.controllers;

import com.tapiwanashe.mbizvo.baseline.api.dto.ApiResponse;
import com.tapiwanashe.mbizvo.baseline.api.entity.IconicCharacter;
import com.tapiwanashe.mbizvo.baseline.api.services.impl.IconCharactersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

        log.atInfo().setMessage("finding all the characters").log();
        return ApiResponse.builder()
                .data(iconCharactersService.findAll())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.ACCEPTED)
                .message("characters")
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<?> findById(@PathVariable Long id) {
        log.atInfo().setMessage("finding character by id: " + id).log();
        return ApiResponse.builder()
                .data(iconCharactersService.findById(id))
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.ACCEPTED)
                .build();
    }

    @PostMapping
    public ApiResponse<?> save(@RequestBody IconicCharacter iconicCharacter) {

        return
                ApiResponse.builder()
                        .data(iconCharactersService.create(iconicCharacter))
                        .status(HttpStatus.CREATED)
                        .timestamp(LocalDateTime.now())
                        .build();
    }
}
