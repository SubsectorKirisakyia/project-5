package com.example.dormitory_management.mappers;

import com.example.dormitory_management.dto.AnnouncementDTO;
import com.example.dormitory_management.entity.Announcement;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AnnouncementMapper {

    public static AnnouncementDTO toDTO(Announcement entity) {
        if (entity == null) return null;

        return AnnouncementDTO.builder()
                .announcementId(entity.getAnnouncementId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public static Announcement toEntity(AnnouncementDTO dto) {
        if (dto == null) return null;

        return Announcement.builder()
                .announcementId(dto.getAnnouncementId()) // Optional — omit if handled by DB
                .title(dto.getTitle())
                .content(dto.getContent())
                .createdAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : LocalDateTime.now())
                .build();
    }

}

