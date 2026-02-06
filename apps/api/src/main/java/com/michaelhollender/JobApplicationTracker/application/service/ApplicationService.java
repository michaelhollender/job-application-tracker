package com.michaelhollender.JobApplicationTracker.application.service;

import com.michaelhollender.JobApplicationTracker.application.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApplicationService {

    // Step 4.6 will inject repositories + implement real logic.
    // Step 4.3/4.5 goal is: method signatures exist and controllers compile.

    public ApplicationResponse createApplication(CreateApplicationRequest request) {
        throw new UnsupportedOperationException("Not implemented yet (Step 4.6)");
    }

    public List<ApplicationResponse> listApplications(String status) {
        throw new UnsupportedOperationException("Not implemented yet (Step 4.6)");
    }

    public ApplicationResponse getApplication(UUID id) {
        throw new UnsupportedOperationException("Not implemented yet (Step 4.6)");
    }

    public ApplicationResponse updateApplication(UUID id, UpdateApplicationRequest request) {
        throw new UnsupportedOperationException("Not implemented yet (Step 4.6)");
    }

    public ApplicationEventResponse addEvent(UUID applicationId, CreateEventRequest request) {
        throw new UnsupportedOperationException("Not implemented yet (Step 4.6)");
    }

    public List<ApplicationEventResponse> listEvents(UUID applicationId) {
        throw new UnsupportedOperationException("Not implemented yet (Step 4.6)");
    }
}
