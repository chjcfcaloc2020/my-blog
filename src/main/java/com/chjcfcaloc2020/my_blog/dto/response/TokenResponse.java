package com.chjcfcaloc2020.my_blog.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TokenResponse {
    private String token;
    private long expiresIn;
}
