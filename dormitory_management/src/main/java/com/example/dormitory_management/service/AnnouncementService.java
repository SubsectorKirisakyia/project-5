package com.example.dormitory_management.service;

import com.example.dormitory_management.dto.AnnouncementDTO;

import java.util.List;
import java.util.Optional;

public interface AnnouncementService {
    AnnouncementDTO createAnnouncement(AnnouncementDTO announcement);
    AnnouncementDTO updateAnnouncement(Long announcementId, AnnouncementDTO announcement);
    void deleteAnnouncement(Long announcementId);
    Optional<AnnouncementDTO> getAnnouncementById(Long announcementId);
    List<AnnouncementDTO> getAllAnnouncements();
}
