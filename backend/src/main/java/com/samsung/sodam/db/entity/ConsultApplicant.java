package com.samsung.sodam.db.entity;

<<<<<<< HEAD
import com.querydsl.core.annotations.QueryProjection;
=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
import com.samsung.sodam.db.converter.ConsultConverter;
import com.samsung.sodam.db.converter.GenderConverter;
import com.samsung.sodam.db.converter.StateAttributeConverter;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
public class ConsultApplicant {
    @Column(name = "session_id") @Id
    private Integer sessionId;
    private String name;
    private Integer age;
    @Convert(converter = ConsultConverter.class)
<<<<<<< HEAD
    private CONSULT_TYPE consultType = CONSULT_TYPE.ALL;
=======
    private CONSULT_TYPE consultType;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
    private String tel;
    private String email;
    @Column(name = "create_date_time")
    private LocalDateTime createdDateTime; //신청일시
    private String content;
    @Convert(converter = GenderConverter.class)
<<<<<<< HEAD
    private GENDER gender = GENDER.MEN;
    @Convert(converter = StateAttributeConverter.class)
    private STATE state = STATE.WAIT; // 신청상태
=======
    private GENDER gender;
    @Convert(converter = StateAttributeConverter.class)
    private STATE state; // 신청상태
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
    @Column(name = "is_consult")
    private String isConsult;
    private Integer turn; // 회차

    @Column(name = "due_date")
    private LocalDateTime dueDate;
<<<<<<< HEAD

    @QueryProjection
    public ConsultApplicant(Integer sessionId, String name, Integer age, CONSULT_TYPE consultType, String tel, String email, LocalDateTime createdDateTime, String content, GENDER gender, STATE state, String isConsult, Integer turn, LocalDateTime dueDate) {
        this.sessionId = sessionId;
        this.name = name;
        this.age = age;
        this.consultType = consultType;
        this.tel = tel;
        this.email = email;
        this.createdDateTime = createdDateTime;
        this.content = content;
        this.gender = gender;
        this.state = state;
        this.isConsult = isConsult;
        this.turn = turn;
        this.dueDate = dueDate;
    }
=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
}