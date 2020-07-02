package it.istat.is2.security;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class JwtConfig {
    @Value("${security.jwt.uri:/api/v1/auth/signin}")
    private String Uri;a

    @Value("${security.jwt.header:jwt-auth}")
    private String header;

    @Value("${security.jwt.prefix:Bearer }")
    private String prefix;

    @Value("${security.jwt.expiration:#{24*60*60}}")
    private int expiration;

    @Value("${security.jwt.secret:it.istat.mec.common.security.JwtSecretKey}")
    private String secret;
	
}
