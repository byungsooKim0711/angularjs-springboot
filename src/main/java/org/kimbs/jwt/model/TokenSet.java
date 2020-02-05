package org.kimbs.jwt.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TokenSet {

    private String refreshToken;

    private String accessToken;
}
