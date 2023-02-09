package com.samsung.sodam.api.request;

import com.samsung.sodam.db.converter.ConsultConverter;
import com.samsung.sodam.db.converter.GenderConverter;
import com.samsung.sodam.db.converter.StateAttributeConverter;
import com.samsung.sodam.db.entity.CONSULT_TYPE;
import com.samsung.sodam.db.entity.GENDER;
import com.samsung.sodam.db.entity.STATE;
<<<<<<< HEAD
import io.swagger.annotations.ApiModelProperty;
=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Convert;
import java.time.LocalDateTime;
<<<<<<< HEAD
import java.time.format.DateTimeFormatter;
=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934

/**
 * 상담요청시 요청할 데이터
 * (최초 상담 요청 시 상담 요청서 작성하는 경우)
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultApplicantRequest {
<<<<<<< HEAD
    @ApiModelProperty(required = true)
    private String counselorId;
    @ApiModelProperty(required = true)
    private String clientId;
    @Convert(converter = StateAttributeConverter.class)
    private STATE state=STATE.WAIT; // 신청상태
    private String name="";
    @Convert(converter = ConsultConverter.class)
    private CONSULT_TYPE consultType = CONSULT_TYPE.ALL;
    @ApiModelProperty(required = true)
    private String tel="";
    private String email="";
    @ApiModelProperty(required = true)
    private String content;
    @Convert(converter = GenderConverter.class)
    @ApiModelProperty(required = true)
    private GENDER gender=GENDER.MEN;
    @ApiModelProperty(required = true)
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dueDate= null; // 희망종료날짜
=======
    private String counselorId;
    private String clientId;
    @Convert(converter = StateAttributeConverter.class)
    private STATE state; // 신청상태
    private String name;
    @Convert(converter = ConsultConverter.class)
    private CONSULT_TYPE consultType;
    private String tel;
    private String email;
    private String content;
    @Convert(converter = GenderConverter.class)
    private GENDER gender;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dueDate; // 희망종료날짜
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
}