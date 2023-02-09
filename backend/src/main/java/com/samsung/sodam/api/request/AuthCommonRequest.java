package com.samsung.sodam.api.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AuthCommonRequest {
    private String id;
    private String password;
<<<<<<< HEAD
    private String newPassword;
=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
    private String isFindId;    // "true" / "false"
    private String email;
    private String name;

    private String confirmCode;

    private String groupCode;
    private String commonCode;
}