# Job Application Tracker (JAT)

A Docker-first, monorepo-based Job Application Tracker built as a portfolio project.
Development happens entirely inside a dev container (git/build/migrations/tests), with SSH agent forwarding for pushing to GitHub.

## Tech Stack (V1)
- Java 21 / Spring Boot
- Spring Data JPA (chosen for v1)
- PostgreSQL 16
- Flyway (migrations)
- Docker Compose + Dev Container
- (UI later) React

## Repo Structure
- `apps/api` — Spring Boot API
- `apps/web` — UI (later / optional in v1)
- `docker/` — devcontainer assets
- `.devcontainer/` — devcontainer config
- `docs/` — architecture + decisions + step roadmap

## V1 Scope (Step 4)
Core flows (Definition of Done):
1. Create an application
2. List applications (optional `status` filter)
3. Update application status and automatically append a `STATUS_CHANGE` event

Out of scope for v1:
- auth/users/roles
- notifications/reminders/jobs
- integrations/scraping
- advanced search/pagination
- attachments/uploads

See: `docs/architecture.md`

## Local Dev (Docker-first)
### Prereqs
- Docker + Docker Compose
- ssh-agent running on host with your GitHub key loaded

### Setup
```bash
cp .env.example .env
docker compose up -d --build
docker compose exec dev bash
```

## Core Features (Planned)
- Application lifecycle tracking
- Status transitions (Applied → Interview → Offer, etc.)
- Event history per application
- Next-action reminders
- Deduplication and prioritization logic

## Status
🚧 In active development

## Author
Michael Hollender
