package com.michaelhollender.JobApplicationTracker.application.dto;

import java.util.Date;

public class CreateEventRequest {

    String type;
    Date eventAt;
    String detail;

    public CreateEventRequest() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getEventAt() {
        return eventAt;
    }

    public void setEventAt(Date eventAt) {
        this.eventAt = eventAt;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
