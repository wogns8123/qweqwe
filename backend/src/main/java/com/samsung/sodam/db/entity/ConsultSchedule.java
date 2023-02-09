package com.samsung.sodam.db.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultSchedule {
    @Id @GeneratedValue
    private Long id;
    @Column(name = "consult_type")
<<<<<<< HEAD
    private CONSULT_TYPE CONSULTTYPE = CONSULT_TYPE.ALL;
=======
    private CONSULT_TYPE CONSULTTYPE;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
    private String tel;
    private String email;
    @Column(name = "first_day_time")
    private LocalDateTime firstDayTime; //신청일시
    private String content;

    private STATE state =STATE.WAIT; // 신청상태
    @Column(name = "date_time")
    LocalDateTime dateTime;//상담 일시
    @Column(name = "is_consult")
    private String isConsult;
    private Integer turn; // 회차
    @Column(name = "session_id")
    private Integer sessionId;

    @Column(name = "openvidu_id")
    private String openviduId; // 화상상담 세션 ID
}