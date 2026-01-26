package com.michaelhollender.JobApplicationTracker.application.dto;

public record UpdateApplicationRequest(

        String status,
        String location,
        String jobUrl,
        String notes
) {}
