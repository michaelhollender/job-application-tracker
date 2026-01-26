```md
# STAR Interview Stories — Job Application Tracker (JAT)

These stories are tied to concrete work already completed in the repo.

---

## 1) Tell me about a time you improved developer productivity or reduced environment issues.

**Situation:** I wanted JAT to be reproducible and “works on any machine,” but local setups often break due to mismatched tool versions and SSH key handling.

**Task:** Make development Docker-first so all work happens inside a dev container, while still allowing secure GitHub access.

**Action:**
- Created a dev container workflow and docker-compose stack with a `dev` container + `postgres` container.
- Used SSH agent forwarding so pushes work from inside the container without copying private keys.
- Standardized environment variables via a single `.env` file and committed `.env.example`.

**Result:**
- I can clone the repo, run `docker compose up`, enter the dev container, and immediately build/run tools with consistent versions.
- GitHub auth works from inside the container via SSH agent forwarding.
- This eliminated “works on my machine” problems and made onboarding predictable.

**What I learned:** The fastest way to move is to stabilize the environment first. Containerizing the workflow upfront prevents repeated context switching and debugging later.

---

## 2) Tell me about a time you prevented scope creep while still making progress.

**Situation:** Feature ideas (auth, reminders, dashboards, scraping) can explode a v1 and delay shipping.

**Task:** Deliver a usable v1 without over-architecting.

**Action:**
- Wrote a v1 contract in `docs/architecture.md` defining only 3 core flows (create/list/update-status+event).
- Explicitly documented “out of scope for v1” items and treated them as v2 backlog.
- Implemented the API in small, staged commits to lock the contract before business logic.

**Result:**
- I have a clean implementation path and commit history that shows a disciplined approach:
  contract → controllers → DTOs → (next) domain model/entities/repos/services.

**What I learned:** Writing a hard v1 contract early is the simplest way to prevent design drift and keep shipping velocity high.

---

## 3) Tell me about a time you designed a clean API boundary.

**Situation:** API layers can accidentally leak persistence models and cause tight coupling.

**Task:** Define stable request/response shapes before implementing persistence and logic.

**Action:**
- Created DTOs for v1 requests/responses (CreateApplicationRequest, UpdateApplicationRequest, ApplicationResponse, CreateEventRequest, ApplicationEventResponse).
- Kept DTOs flat and minimal to avoid coupling to entities.
- Reserved business rules for the service layer (controllers only do validation and mapping).

**Result:**
- The API contract is stable and can evolve independently from the DB layer.
- The project remains modular-ready without prematurely splitting modules.

**What I learned:** DTO-first design keeps boundaries clean and makes it easier to refactor internal structure later without breaking external callers.
