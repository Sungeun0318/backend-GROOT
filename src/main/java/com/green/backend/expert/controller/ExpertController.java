package com.green.backend.expert.controller;

import com.green.backend.expert.dto.ExpertDTO;
import com.green.backend.expert.service.ExpertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/specialist")
public class ExpertController {

    private final ExpertService expertService;


    @PostMapping
    public ResponseEntity<?> createSpecialist(@RequestBody ExpertDTO expertDTO){

        boolean result = expertService.createSpecialist(expertDTO);
        return ResponseEntity.ok( result );
    }

}
