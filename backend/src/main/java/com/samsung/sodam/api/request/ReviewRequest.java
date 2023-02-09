package com.samsung.sodam.api.request;

<<<<<<< HEAD
import io.swagger.annotations.ApiModelProperty;
=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ReviewRequest {
    //최신순, 별점순
<<<<<<< HEAD
    @ApiModelProperty(value="상담 타입", example="EDUCATION",required = false)
    String type="ALL";
    @ApiModelProperty(value="고객 아이디", example="clientId",required = false)
    String clientId="";
    @ApiModelProperty(value="상담사 아이디", example="counselorId",required = true)
=======
    String type;
    String clientId;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
    String counselorId;
}
