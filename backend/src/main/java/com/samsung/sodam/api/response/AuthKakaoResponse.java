package com.samsung.sodam.api.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.samsung.sodam.api.request.AuthCommonRequest;
import com.samsung.sodam.jwt.TokenDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AuthKakaoResponse {

    private String isFirst = "false";    // "true" / "false"
    private String isInfoRequired = "false";
    private String id;
    private String email;
    private String name;

    private String groupCode;
    private String commonCode;
    TokenDto token;
    public AuthKakaoResponse(AuthCommonRequest request) {
        this.groupCode = request.getGroupCode();
        this.commonCode = request.getCommonCode();
    }

}
