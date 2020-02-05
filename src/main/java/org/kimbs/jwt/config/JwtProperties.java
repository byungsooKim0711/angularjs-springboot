package org.kimbs.jwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private long tokenValidity;

    private String accessTokenKey;

    private String refreshTokenKey;

    private long refreshTokenExpirationValidity;

    private String accessTokenCookieName;

    private String refreshTokenCookieName;

    public void setAccessTokenKey(String accessTokenKey) {
        this.accessTokenKey = Base64.getEncoder().encodeToString(accessTokenKey.getBytes());
    }

    public void setRefreshTokenKey(String refreshTokenKey) {
        this.refreshTokenKey = Base64.getEncoder().encodeToString(refreshTokenKey.getBytes());
    }
}
