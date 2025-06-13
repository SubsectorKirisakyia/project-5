package com.example.dormitory_management.controller;

import com.example.dormitory_management.dto.RoomApplicationDTO;
import com.example.dormitory_management.exception.ResourceNotFoundException;
import com.example.dormitory_management.service.RoomApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms/applications")
@RequiredArgsConstructor
public class RoomApplicationController {

    private final RoomApplicationService roomApplicationService;

    @GetMapping
    public ResponseEntity<List<RoomApplicationDTO>> getAllRoomApplications() {
        return ResponseEntity.ok(roomApplicationService.getAllRoomApplications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomApplicationDTO> getRoomApplicationById(@PathVariable Long id) {
        RoomApplicationDTO dto = roomApplicationService.getRoomApplicationById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find roomApplication"));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<RoomApplicationDTO> createRoomApplication(@Valid @RequestBody RoomApplicationDTO roomApplicationDTO) {
        return ResponseEntity.ok(roomApplicationService.createRoomApplication(roomApplicationDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomApplicationDTO> updateRoomApplication(@PathVariable Long id, @Valid @RequestBody RoomApplicationDTO roomApplicationDTO) {
        return ResponseEntity.ok(roomApplicationService.updateRoomApplication(id, roomApplicationDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomApplication(@PathVariable Long id) {
        roomApplicationService.deleteRoomApplication(id);
        return ResponseEntity.noContent().build();
    }
}