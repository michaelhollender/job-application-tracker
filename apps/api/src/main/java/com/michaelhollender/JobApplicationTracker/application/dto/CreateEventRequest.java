package com.michaelhollender.JobApplicationTracker.application.dto;

import jakarta.validation.constraints.NotBlank;
import java.time.Instant;

public record CreateEventRequest(

        @NotBlank
        String type, // NOTE (STATUS_CHANGE is internal-only in v1)

        Instant eventAt, // optional; default to now if null

        String detail
) {}
