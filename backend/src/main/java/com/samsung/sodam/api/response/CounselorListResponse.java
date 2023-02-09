package com.samsung.sodam.api.response;

import com.querydsl.core.annotations.QueryProjection;
<<<<<<< HEAD
import com.samsung.sodam.db.converter.CareerListConverter;
import com.samsung.sodam.db.converter.ConsultListConverter;
import com.samsung.sodam.db.converter.GenderConverter;
import com.samsung.sodam.db.entity.CONSULT_TYPE;
import com.samsung.sodam.db.entity.Career;
import com.samsung.sodam.db.entity.GENDER;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
=======
import com.samsung.sodam.db.converter.GenderConverter;
import com.samsung.sodam.db.entity.GENDER;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Convert;

@Getter
@Setter
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
public class CounselorListResponse {
    @ApiModelProperty(value = "상담사 이름")
    private String name;
    @ApiModelProperty(value = "상담사 전화번호")
<<<<<<< HEAD
    private String tel="";
    @ApiModelProperty(value = "상담사 이메일")
    private String email="";
    @ApiModelProperty(value = "상담사 아이디")
    private String id;

    @ApiModelProperty(value = "상담사 소개글")
    private String introduce="";

    @ApiModelProperty(value = "상담사 성별")
    @Convert(converter = GenderConverter.class)
    GENDER gender;
    @ApiModelProperty(value = "상담사 ??")
    private String routine="";
    @ApiModelProperty(value = "상담사 프로필 이미지")
    private String profileImg="";
    @Column(name = "consult_type")
    @ApiModelProperty(value = "상담사 상담 분야")
    @Convert(converter = ConsultListConverter.class)
    private List<CONSULT_TYPE> consultTypeList = null;



    @Column(name="career")
    @ApiModelProperty(value = "상담사 경력")
    @Convert(converter = CareerListConverter.class)
    private List<Career> career;

    @QueryProjection
    //public CounselorListResponse(String name, String tel, String email, String id, String introduce, GENDER gender, String routine, String profileImg, List<CONSULT_TYPE> consultTypeList, List<Education> education, List<Career> career) {
    public CounselorListResponse(String name, String tel, String email, String id, String introduce, GENDER gender, String routine, String profileImg, List<CONSULT_TYPE> consultTypeList, List<Career> career) {
        this.name = name;
        this.tel = tel;
        this.email = email;
        this.id = id;
        this.introduce = introduce;
        this.gender = gender;
        this.routine = routine;
        this.profileImg = profileImg;
        this.consultTypeList = consultTypeList;
//        this.education = education;
        this.career = career;
=======
    private String tel;
    @ApiModelProperty(value = "상담사 이메일")
    private String email;
    @ApiModelProperty(value = "상담사 아이디")
    private String id;
    @ApiModelProperty(value = "상담사 경력")
    private String career;
    @ApiModelProperty(value = "상담사 소개글")
    private String introduce;

    @ApiModelProperty(value = "상담사 전공")
    private String major;
    @ApiModelProperty(value = "상담사 성별")
    @Convert(converter = GenderConverter.class)
    GENDER gender;
    @ApiModelProperty(value = "상담사 이메일")
    private String routine;
    @ApiModelProperty(value = "상담사 프로필 이미지")
    private String profileImg;

    @QueryProjection
    public CounselorListResponse(String name, String tel, String email, String id, String career, String introduce, String major, GENDER gender, String routine, String profileImg) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.career = career;
        this.introduce = introduce;
        this.major = major;
        this.gender = gender;
        this.routine = routine;
        this.profileImg = profileImg;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
    }
}
