package com.samsung.sodam.db.repository;

<<<<<<< HEAD
import com.samsung.sodam.api.response.ClientListResponse;
import com.samsung.sodam.api.response.CounselorListResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientResponseCustomRepository {
//    public Page<ClientListResponse> getClientList(String userId, Pageable pageable);
    public Page<ClientListResponse> getAllClientList(String userId, Pageable pageable);
    public List<CounselorListResponse> getReviewByAvg();
=======
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsung.sodam.api.response.ClientListResponse;
import com.samsung.sodam.api.response.QClientListResponse;
import com.samsung.sodam.db.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.samsung.sodam.db.entity.QClient.client;
import static com.samsung.sodam.db.entity.QConsultSession.consultSession;

public interface ClientResponseCustomRepository {
    public Page<ClientListResponse> getClientList(String userId, String searchWord, Pageable pageable);
    public Page<ClientListResponse> getAllClientList(String userId, Pageable pageable);
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
}
