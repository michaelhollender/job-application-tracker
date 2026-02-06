
package com.michaelhollender.JobApplicationTracker.application.entity;

import com.michaelhollender.JobApplicationTracker.application.model.EventType;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "application_events")
public class ApplicationEventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "application_id", nullable = false)
    private UUID applicationId;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false)
    private EventType type;

    @Column(name = "event_at", nullable = false)
    private Instant eventAt;

    @Column(columnDefinition = "text")
    private String detail;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private Instant createdAt;

    protected ApplicationEventEntity() {}

    public UUID getId() {
        return id;
    }

    public UUID getApplicationId() {
        return applicationId;
    }
    public void setApplicationId(UUID applicationId) {
        this.applicationId = applicationId;
    }

    public EventType getType() {
        return type;
    }
    public void setType(EventType type) {
        this.type = type;
    }

    public Instant getEventAt() {
        return eventAt;
    }
    public void setEventAt(Instant eventAt) {
        this.eventAt = eventAt;
    }

    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
