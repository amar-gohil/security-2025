CREATE TABLE oauth_client (
    id VARCHAR(255) PRIMARY KEY,
    client_id VARCHAR(255) UNIQUE NOT NULL,         -- Generated Unique Client ID
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


INSERT INTO AuthorizationServer.users
(id, username, password, enabled, created_at)
VALUES(0, 'user', 'password', 1, NOW());


INSERT INTO AuthorizationServer.oauth_client
(id, client_id, client_secret, client_name, scopes, grant_types, redirect_uris, token_ttl, refresh_token_ttl, created_at)
VALUES('dc104103-6911-4ea2-8c33-119e592e65b1', 'one-client-id', 'client-secret','one-client-id' , 'authorization_code,refresh_token,client_credentials', 'openid,user.read,user.write', 'http://google.com', 3600, 86400, NOW());
