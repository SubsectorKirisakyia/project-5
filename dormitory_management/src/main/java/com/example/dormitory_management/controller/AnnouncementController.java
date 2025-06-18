package com.example.dormitory_management.controller;

import com.example.dormitory_management.dto.AnnouncementDTO;
import com.example.dormitory_management.exception.ResourceNotFoundException;
import com.example.dormitory_management.service.AnnouncementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
@RequiredArgsConstructor
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @GetMapping
    public ResponseEntity<List<AnnouncementDTO>> getAllAnnouncements() {
        return ResponseEntity.ok(announcementService.getAllAnnouncements());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementDTO> getAnnouncementById(@PathVariable Long id) {
        AnnouncementDTO dto = announcementService.getAnnouncementById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find announcement"));
        return ResponseEntity.ok(dto);
    }


    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<AnnouncementDTO> createAnnouncement(@Valid @RequestBody AnnouncementDTO announcementDTO) {
        return ResponseEntity.ok(announcementService.createAnnouncement(announcementDTO));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<AnnouncementDTO> updateAnnouncement(@PathVariable Long id, @Valid @RequestBody AnnouncementDTO announcementDTO) {
        return ResponseEntity.ok(announcementService.updateAnnouncement(id, announcementDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<Void> deleteAnnouncement(@PathVariable Long id) {
        announcementService.deleteAnnouncement(id);
        return ResponseEntity.noContent().build();
    }
}