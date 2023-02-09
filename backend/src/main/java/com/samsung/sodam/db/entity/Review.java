package com.samsung.sodam.db.entity;

import com.querydsl.core.annotations.QueryProjection;
<<<<<<< HEAD
import io.swagger.annotations.ApiModelProperty;
=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Table
@Entity
@Getter
@Setter
@NoArgsConstructor

public class Review {
    @Id
    @Column(name = "review_id")
    @GeneratedValue
    Long id;

    @Column(length = 500)
    String contents;
    @ApiModelProperty(required = true)
    Double stars;
    @Column(name = "past_count")
    Integer pastCount=0;

    String type="ALL";
    @Column(name = "client_id")
    @ApiModelProperty(required = true)
    String clientId;

    @Column(name = "counselor_Id")
    @ApiModelProperty(required = true)
    String counselorId;

    @Column(name = "created_at")
    LocalDateTime createdAt;

<<<<<<< HEAD
    @ApiModelProperty(required = true)
    String title;

    @QueryProjection
    public Review(Long id, String contents, Double stars, Integer pastCount, String type, String clientId, String counselorId, LocalDateTime createdAt) {
        this.id = id;
        this.contents = contents;
        this.stars = stars;
=======
    @QueryProjection
    public Review(Long id, String contents, Double starts, Integer pastCount, String type, String clientId, String counselorId, LocalDateTime createdAt) {
        this.id = id;
        this.contents = contents;
        this.starts = starts;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
        this.pastCount = pastCount;
        this.type = type;
        this.clientId = clientId;
        this.counselorId = counselorId;
        this.createdAt = createdAt;
    }
}
