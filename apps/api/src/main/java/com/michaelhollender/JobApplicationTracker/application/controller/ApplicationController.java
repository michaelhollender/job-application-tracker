package com.michaelhollender.JobApplicationTracker.application.controller;

import com.michaelhollender.JobApplicationTracker.application.service.ApplicationService;
import com.michaelhollender.JobApplicationTracker.application.dto.CreateApplicationRequest;
import com.michaelhollender.JobApplicationTracker.application.dto.ApplicationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ApplicationController {
    
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/applications")
    public ApplicationResponse createApplication(@RequestBody CreateApplicationRequest request) {
        return applicationService.createApplication(request);
    }

    @GetMapping("/applications")
    public ResponseEntity<String> getApplicationStatus(@RequestParam("status") String status) {
        return ResponseEntity.ok(status);
    }
}
