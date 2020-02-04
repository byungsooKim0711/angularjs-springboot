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

    private String secretKey;

    private long refreshTokenExpirationValidity;

    private String accessTokenCookieName;

    private String refreshTokenCookieName;

    public void setSecretKey(String secretKey) {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }
}
