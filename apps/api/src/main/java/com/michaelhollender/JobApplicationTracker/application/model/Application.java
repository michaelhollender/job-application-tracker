package com.michaelhollender.JobApplicationTracker.application.model;

import java.time.Instant;
import java.util.UUID;

public record Application(
        UUID id,
        String company,
        String title,
        String location,
        String jobUrl,
        ApplicationStatus status,
        Instant createdAt,
        Instant updatedAt
) {}
