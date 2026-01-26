package com.michaelhollender.JobApplicationTracker.application.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateApplicationRequest(

        @NotBlank
        String company,

        @NotBlank
        String title,

        String location,

        String jobUrl,

        String notes
) {}
