package com.michaelhollender.JobApplicationTracker.application.model;

import java.time.Instant;
import java.util.UUID;

public record ApplicationEvent(
        UUID id,
        UUID applicationId,
        EventType type,
        Instant eventAt,
        String detail,
        Instant createdAt
) {}
