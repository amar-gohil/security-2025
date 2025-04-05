package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "oauth_client")
public class OAuthClient {

    @Id
    @Column(name = "client_id", nullable = false, unique = true)
    private String clientId;  // Generated Client ID

    @Column(name = "client_secret", nullable = false)
    private String clientSecret;  // Hashed Secret

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "scopes", nullable = false)
    private String scopes;  // Comma-separated list (e.g., "read,write")

    @Column(name = "grant_types", nullable = false)
    private String grantTypes;  // Comma-separated list (e.g., "authorization_code,client_credentials")

    @Column(name = "redirect_uris")
    private String redirectUris;  // Comma-separated list

    @Column(name = "token_ttl")
    private Integer tokenTtl = 3600;  // Default: 1 hour

    @Column(name = "refresh_token_ttl")
    private Integer refreshTokenTtl = 86400;  // Default: 1 day

    @Column(name = "created_at", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

}
