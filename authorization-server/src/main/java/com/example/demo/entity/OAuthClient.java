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
    @Column(name = "id", nullable = false, unique = true)
    private String id;  // Generated Client ID

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public String getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(String grantTypes) {
        this.grantTypes = grantTypes;
    }

    public String getRedirectUris() {
        return redirectUris;
    }

    public void setRedirectUris(String redirectUris) {
        this.redirectUris = redirectUris;
    }

    public Integer getTokenTtl() {
        return tokenTtl;
    }

    public void setTokenTtl(Integer tokenTtl) {
        this.tokenTtl = tokenTtl;
    }

    public Integer getRefreshTokenTtl() {
        return refreshTokenTtl;
    }

    public void setRefreshTokenTtl(Integer refreshTokenTtl) {
        this.refreshTokenTtl = refreshTokenTtl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
