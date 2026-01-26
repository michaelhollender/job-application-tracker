package com.michaelhollender.JobApplicationTracker.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ApplicationEventController {

    @PostMapping("/applications/{id}/events")
    public  ResponseEntity<String> createApplicationEvent(@PathVariable("id") Long id,
                                                          @RequestBody Object request) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body("Invalid application id");
        }

        // 4.1 Stub: resource existence check will be done in service later
        // For now, keep a placeholder 404 path you can remove once service exists:
        // return ResponseEntity.status(404).body("Application not found")

        return ResponseEntity.ok("TODO: create event for application " + id);
    }

    @GetMapping("/applications/{id}/events")
    public ResponseEntity<String> getApplicationEvents(@PathVariable("id") Long id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body("Invalid application id");
        }

        // 4.1 Stub: resource existence check will be done in service layer
        // For now, keep a placeholder 404 path you can remove once service exists:
        // return ResponseEntity.status(404).body("Application not found")

        return ResponseEntity.ok("TODO: get events for application " + id);
    }
}
