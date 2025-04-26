package com.example.demo.repository;

import com.example.demo.entity.OAuthClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OAuth2RegisteredClientRepository extends JpaRepository<OAuthClient,String> {
    OAuthClient findByClientId(String clientId);
}
