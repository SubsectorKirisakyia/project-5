package com.example.dormitory_management.service.impl;

import com.example.dormitory_management.dto.AnnouncementDTO;
import com.example.dormitory_management.entity.Announcement;
import com.example.dormitory_management.mappers.AnnouncementMapper;
import com.example.dormitory_management.repository.AnnouncementRepository;
import com.example.dormitory_management.service.AnnouncementService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    
    @Override
    public AnnouncementDTO createAnnouncement(AnnouncementDTO announcementDTO) {
        Announcement announcement = AnnouncementMapper.toEntity(announcementDTO);
        return AnnouncementMapper.toDTO(announcementRepository.save(announcement));
    }

    @Override
    public AnnouncementDTO updateAnnouncement(Long announcementId, AnnouncementDTO updatedAnnouncement) {
        Announcement existingAnnouncement = announcementRepository.findById(announcementId)
                .orElseThrow(() -> new EntityNotFoundException("Announcement not found with ID: " + announcementId));

        existingAnnouncement.setTitle(updatedAnnouncement.getTitle());
        existingAnnouncement.setContent(updatedAnnouncement.getContent());

        return AnnouncementMapper.toDTO(announcementRepository.save(existingAnnouncement));
    }

    @Override
    public void deleteAnnouncement(Long announcementId) {
        if (!announcementRepository.existsById(announcementId)) {
            throw new EntityNotFoundException("Announcement not found with ID: " + announcementId);
        }
        announcementRepository.deleteById(announcementId);
    }

    @Override
    public Optional<AnnouncementDTO> getAnnouncementById(Long announcementId) {
        Announcement announcement = announcementRepository.findById(announcementId).orElseThrow(() -> new EntityNotFoundException("Announcement was not found with ID: " + announcementId));
        return Optional.of(AnnouncementMapper.toDTO(announcement));
    }

    @Override
    public List<AnnouncementDTO> getAllAnnouncements() {
        List<Announcement> announcementList = announcementRepository.findAll();
        return announcementList.stream().map(AnnouncementMapper::toDTO).collect(Collectors.toList());
    }
}