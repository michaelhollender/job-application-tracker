package com.michaelhollender.JobApplicationTracker.application.repo;

import com.michaelhollender.JobApplicationTracker.application.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationEntity, UUID> {
    // nothing needed yet; JpaRepository already provides save, findById, findAll, deleteById, etc.
}