
# Dev container with Java + Maven + Node + Git + SSH client
# Keep it simple and predictable for v1.

FROM ubuntu:24.04

ARG DEBIAN_FRONTEND=noninteractive
ARG USERNAME=ubuntu
ARG USER_UID=1000
ARG USER_GID=1000

# Base tools
RUN apt-get update && apt-get install -y --no-install-recommends \
    ca-certificates \
    curl \
    git \
    openssh-client \
    bash \
    unzip \
    zip \
    jq \
    nano \
    less \
    sudo \
    gnupg \
    postgresql-client \
    netcat-openbsd \
 && rm -rf /var/lib/apt/lists/*

# Java 21 + Maven
RUN apt-get update && apt-get install -y --no-install-recommends \
    openjdk-21-jdk \
    maven \
 && rm -rf /var/lib/apt/lists/*

# Node.js LTS (from NodeSource)
# (Pinning to a major LTS line avoids surprises)
RUN curl -fsSL https://deb.nodesource.com/setup_20.x | bash - \
 && apt-get update && apt-get install -y --no-install-recommends nodejs \
 && rm -rf /var/lib/apt/lists/*

# Use the pre-existing ubuntu user (UID/GID 1000) and ensure it has sudo.
RUN set -eux; \
    id -u ${USERNAME} >/dev/null 2>&1; \
    echo "${USERNAME} ALL=(ALL) NOPASSWD:ALL" > /etc/sudoers.d/${USERNAME}; \
    chmod 0440 /etc/sudoers.d/${USERNAME}

# SSH known_hosts for GitHub (prevents interactive prompt)
RUN mkdir -p /etc/ssh \
 && ssh-keyscan -t rsa,ecdsa,ed25519 github.com >> /etc/ssh/ssh_known_hosts

# Nice defaults
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
ENV PATH="$PATH:/usr/lib/jvm/java-21-openjdk-amd64/bin"

WORKDIR /workspace

USER ${USERNAME}

# Keep container alive for interactive dev
CMD ["bash", "-lc", "sleep infinity"]
