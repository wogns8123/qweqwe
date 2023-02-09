package com.samsung.sodam.api.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
<<<<<<< HEAD
import com.samsung.sodam.db.converter.ConsultListConverter;
import com.samsung.sodam.db.converter.GenderConverter;
import com.samsung.sodam.db.entity.CONSULT_TYPE;
import com.samsung.sodam.db.entity.Career;
=======
import com.samsung.sodam.db.converter.GenderConverter;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
import com.samsung.sodam.db.entity.GENDER;
import com.samsung.sodam.db.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Convert;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
import javax.persistence.Converter;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CounselorRequest {

    private String isKakaoRegister = "false";
    private String id;
    private String password;
    private String name;

    private String tel;
    private String email;


    private String introduce;
    private String major;
    @Convert(converter = GenderConverter.class)
    private GENDER gender;
    private String[] routine;
    private Role role = Role.COUNSELOR;

    private int enterpriseId;
<<<<<<< HEAD
    private String enterprisestr;

    private String profileImg;

//    private List<Education> educationRow;
    private List<Career> careers;

    //private List<String> consultType;
    //private Integer[] consultType;

    @Convert(converter = ConsultListConverter.class)
    private ArrayList<CONSULT_TYPE> consultType;


    ArrayList<CertRequest> certificateList;
=======

    private String profileImg;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
}