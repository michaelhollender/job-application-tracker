package com.michaelhollender.JobApplicationTracker.application.dto;

import java.time.Instant;
import java.util.UUID;

public record ApplicationResponse(
        UUID id,
        String company,
        String title,
        String location,
        String jobUrl,
        String status,
        Instant createdAt,
        Instant updatedAt
) {}
