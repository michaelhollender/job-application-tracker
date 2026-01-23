-- V1__init.sql
-- Minimal v1 schema for Job Application Tracker (PostgreSQL 16)

BEGIN;

-- Needed for gen_random_uuid()
CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS applications (
                                            id         UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                            company    TEXT NOT NULL,
                                            title      TEXT NOT NULL,
                                            location   TEXT,
                                            job_url    TEXT,
                                            status     TEXT NOT NULL,
                                            created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
                                            updated_at TIMESTAMPTZ NOT NULL DEFAULT now()
);

CREATE INDEX IF NOT EXISTS idx_applications_status
    ON applications(status);

CREATE TABLE IF NOT EXISTS application_events (
                                                  id             UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                                  application_id UUID NOT NULL,
                                                  event_type     TEXT NOT NULL,
                                                  event_at       TIMESTAMPTZ NOT NULL DEFAULT now(),
                                                  detail         TEXT,
                                                  created_at     TIMESTAMPTZ NOT NULL DEFAULT now(),
                                                  CONSTRAINT fk_application_events_application
                                                      FOREIGN KEY (application_id)
                                                          REFERENCES applications(id)
                                                          ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS idx_application_events_app_id
    ON application_events(application_id);

CREATE INDEX IF NOT EXISTS idx_application_events_event_at
    ON application_events(event_at);

COMMIT;
























