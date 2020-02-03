package org.kimbs.jwt.model.code;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public enum RoleCode {
    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER")
    ;

    private String code;

    RoleCode(String code) {
        this.code = code;
    }

    private static Map<String, RoleCode> map = Arrays.stream(values()).collect(Collectors.toMap(RoleCode::getCode, Function.identity()));

    public static RoleCode fromValue(String value) throws IllegalArgumentException {
        return Optional.ofNullable(map.get(value)).orElseThrow(() -> new IllegalArgumentException("Not exists code : " + value));
    }

}
