package com.michaelhollender.JobApplicationTracker.application.controller;

import com.michaelhollender.JobApplicationTracker.application.service.ApplicationService;
import com.michaelhollender.JobApplicationTracker.application.dto.CreateApplicationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ApplicationEventController {

    private final ApplicationService applicationService;

    public ApplicationEventController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/applicaitons/{id}/events")
    public  ResponseEntity<String> createApplicationEvent(@PathVariable("id") Long id,
                                                          @RequestBody CreateApplicationRequest request) {
        // NUDGE: this should call an "add event" service method + use an event request DTO.
        // Leaving your existing service call out because it's the wrong operation.
        return  ResponseEntity.ok("TODO: create event for application " + id);
    }

    @GetMapping("/applications/{id}/events")
    public ResponseEntity<String> getApplicationEvents(@PathVariable("id") Long id) {
        // NUDGE: this should return event DTOs for the application.
        return ResponseEntity.ok("TODO: get events for application " + id);
    }
}
