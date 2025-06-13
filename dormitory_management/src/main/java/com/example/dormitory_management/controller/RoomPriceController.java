package com.example.dormitory_management.controller;

import com.example.dormitory_management.dto.RoomPriceDTO;
import com.example.dormitory_management.exception.ResourceNotFoundException;
import com.example.dormitory_management.service.RoomPriceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms/prices")
@RequiredArgsConstructor
public class RoomPriceController {

    private final RoomPriceService roomPriceService;

    @GetMapping
    public ResponseEntity<List<RoomPriceDTO>> getAllRoomPrices() {
        return ResponseEntity.ok(roomPriceService.getAllRoomPrices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomPriceDTO> getRoomPriceById(@PathVariable Long id) {
        RoomPriceDTO dto = roomPriceService.getRoomPriceById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find roomPrice"));
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<RoomPriceDTO> createRoomPrice(@Valid @RequestBody RoomPriceDTO roomPriceDTO) {
        return ResponseEntity.ok(roomPriceService.createRoomPrice(roomPriceDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomPriceDTO> updateRoomPrice(@PathVariable Long id, @Valid @RequestBody RoomPriceDTO roomPriceDTO) {
        return ResponseEntity.ok(roomPriceService.updateRoomPrice(id, roomPriceDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoomPrice(@PathVariable Long id) {
        roomPriceService.deleteRoomPrice(id);
        return ResponseEntity.noContent().build();
    }
}