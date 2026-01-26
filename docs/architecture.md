# Job Application Tracker (JAT) Architecture

## V1 Goal
Ship a working vertical slice with:
- Docker-first dev workflow (all work inside dev container)
- Postgres + Flyway migrations
- Minimal API that supports core tracking flows

This document is the source of truth for v1 scope and guardrails.

---

## V1 Scope (Step 4)

### Core flows (Definition of Done)
1) Create an application
2) List applications (optional filter: status)
3) Update an application’s status AND automatically append a status-change event

If all 3 flows work via curl/Postman against the running stack, Step 4 is complete.

### Explicitly out of scope for V1
- Authentication / users / roles
- Notifications (email/text), scheduled jobs, reminders
- Resume parsing, scraping, job board integrations
- “Next action engine”, automation, analytics dashboards
- Full-text search, complex filtering, pagination
- Multi-module builds / microservices / CQRS
- Attachments / file uploads

If something feels “small to add”, it goes into V2 backlog and is not implemented in Step 4.

---

## Data Model (V1)

### Tables (only these two)
1) applications
2) application_events

### Event rules
- Events are append-only (never updated in v1)
- Status changes create exactly one event with type = STATUS_CHANGE

### Status values (v1 set)
- SAVED
- APPLIED
- INTERVIEW
- OFFER
- REJECTED

---

## API Contract (V1)

### Applications
- POST /applications
    - Creates an application
    - Default status: SAVED

- GET /applications
    - Lists applications
    - Optional query: ?status=SAVED|APPLIED|INTERVIEW|OFFER|REJECTED

- GET /applications/{id}
    - Returns one application
    - 404 if not found

- PATCH /applications/{id}
    - Updates allowed fields (v1): status, location, jobUrl, notes
    - If status changes: write STATUS_CHANGE event
    - 404 if not found
    - 400 for invalid input (unknown status, invalid UUID, etc.)

### Application Events
- POST /applications/{id}/events
    - Appends an event (v1 type: NOTE)
    - 404 if application not found

- GET /applications/{id}/events
    - Lists events newest-first
    - 404 if application not found

---

## Layering Rules (Guardrails)

### Controllers
- Validation + DTO mapping only
- No DB calls
- No business rules

### Services
- Own all business logic
- Own transaction boundaries
- “Update status + write event” must be atomic

### Repositories
- Spring Data JPA only
- No complex querying in v1 (no specs, no pagination, no projections)

### Migrations
- Flyway migrations are append-only
- Migrations live in: apps/api/src/main/resources/db/migration
- Never edit a migration after it has been merged; add a new V# migration instead

---

## Dev Workflow (Golden Path)
- Start stack from host: docker compose up -d --build
- Do all work inside dev container: git, builds, migrations, tests
- Push to GitHub from inside dev container via SSH agent forwarding
- Reset DB (local only): docker compose down -v && docker compose up -d --build
