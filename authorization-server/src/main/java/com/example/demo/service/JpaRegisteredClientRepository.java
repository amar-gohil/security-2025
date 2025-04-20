package com.example.demo.service;

import com.example.demo.entity.OAuthClient;
import com.example.demo.repository.OAuth2RegisteredClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Primary
public class JpaRegisteredClientRepository implements RegisteredClientRepository {

    @Autowired
    OAuth2RegisteredClientRepository oAuth2RegisteredClientRepository;

    @Override
    public void save(RegisteredClient registeredClient) {

    }

    @Override
    public RegisteredClient findById(String id) {
        return oAuth2RegisteredClientRepository.findById(id)
                .map(this::toRegisteredClient)
                .orElse(null);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        OAuthClient oAuthClient = oAuth2RegisteredClientRepository.findByClientId(clientId);
        if (oAuthClient == null) {
            return null;
        }

        return toRegisteredClient(oAuthClient);
    }
    private RegisteredClient toRegisteredClient(OAuthClient entity) {
        System.out.println("..........." + entity.toString());
        Set<AuthorizationGrantType> grantTypeSet = Arrays.stream(entity.getGrantTypes().split(","))
                .map(AuthorizationGrantType::new).collect(Collectors.toSet());
        Set<String> scopeSet = Arrays.stream(entity.getScopes().split(",")).collect(Collectors.toSet());
        return RegisteredClient.withId(entity.getId())
                .clientId(entity.getClientId())
                .clientSecret(entity.getClientSecret())
                //.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                //.authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .scopes(scopes -> scopes.addAll(scopeSet))
                .authorizationGrantTypes(grantTypes -> grantTypes.addAll(grantTypeSet))// Map properly if stored as comma-separated string
                //.tokenSettings(TokenSettings.withSettings(Collections.emptyMap()).build())
                //.clientSettings(ClientSettings.withSettings(Collections.emptyMap()).build())
                .redirectUri(entity.getRedirectUris())
                .build();
/*        RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("client-id")
                .clientSecret("client-secret")
                .authorizationGrantTypes(grantTypes -> grantTypes.addAll(Set.of(
                        AuthorizationGrantType.CLIENT_CREDENTIALS,
                        AuthorizationGrantType.AUTHORIZATION_CODE,
                        AuthorizationGrantType.REFRESH_TOKEN)))
                .redirectUri("http://google.com")
                .scopes(scopes -> scopes.addAll(
                        Set.of("user.read", "user.write", OidcScopes.OPENID)))
                .scope("profile")
                .build();*/
    }
}
