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
    public ResponseEntity<?> createApplication(@RequestBody CreateApplicationRequest request) {
        if (request == null) {
            return ResponseEntity.badRequest().body("Invalid request body");
        }
        // Optional: add a couple obvious field checks once you know required fields
        // if (request.getCompanyName() == null || request.getCompanyName().isBlank()) ...

        return ResponseEntity.ok(applicationService.createApplication(request));
    }

    @GetMapping("/applications")
    public ResponseEntity<String> listApplications(@RequestParam(value = "status", required = false) String status) {
        // 4.1 stub: status validation would go here (if provided)
        // if (status != null && !isValidStatus(status)) return 400;

        return ResponseEntity.ok("TODO: list application" + (status != null ? " with status " + status : ""));
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<String> getApplicationById(@PathVariable("id") Long id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body("Invalid application id");
        }

        // 4.1 stub:
        return ResponseEntity.ok("TODO: get application " + id);
        // later: return 404 when service says not found
    }

    @PatchMapping("/applications/{id}")
    public ResponseEntity<String> updateApplication(@PathVariable("id") Long id,
                                                    @RequestBody Object request) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().body("Invalid application id");
        }
        if (request == null) {
           return ResponseEntity.badRequest().body("Invalid request body");
        }

        // 4.1 stub:
        return ResponseEntity.ok("TODO: patch application " + id);
        // later: validate patch fields -> 400; not found -> 404
    }
}
