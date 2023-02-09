package com.samsung.sodam.api.response;

import com.querydsl.core.annotations.QueryProjection;
<<<<<<< HEAD
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
=======
import lombok.Getter;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
import lombok.Setter;

@Getter
@Setter
<<<<<<< HEAD
@Builder
=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
public class ClientListResponse {
    String id;
    String name;
    String email;
    String tel;

    @QueryProjection
    public ClientListResponse(String id, String name, String email, String tel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
    }
}
