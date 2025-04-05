CREATE TABLE oauth_client (
    client_id VARCHAR(255) PRIMARY KEY,         -- Generated Unique Client ID
    client_secret VARCHAR(255) NOT NULL,        -- Generated Secret (Hashed)
    client_name VARCHAR(255) NOT NULL,          -- Client App Name
    scopes VARCHAR(255) NOT NULL,               -- Allowed Scopes (Comma-separated)
    grant_types VARCHAR(255) NOT NULL,          -- Allowed Grant Types (Comma-separated)
    redirect_uris VARCHAR(2048),                -- Redirect URIs (Comma-separated)
    token_ttl INT DEFAULT 3600,                 -- Access Token TTL (Seconds)
    refresh_token_ttl INT DEFAULT 86400,        -- Refresh Token TTL (Seconds)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE users (
    id SERIAL PRIMARY KEY,                     -- Unique User ID
    username VARCHAR(255) UNIQUE NOT NULL,     -- Username
    password VARCHAR(255) NOT NULL,            -- Hashed Password
    enabled BOOLEAN DEFAULT TRUE,              -- Account active status
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_roles (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users(username) ON DELETE CASCADE
);
