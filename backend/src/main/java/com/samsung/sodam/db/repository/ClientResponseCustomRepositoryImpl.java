package com.samsung.sodam.db.repository;

<<<<<<< HEAD
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsung.sodam.api.response.ClientListResponse;
import com.samsung.sodam.api.response.CounselorListResponse;
import com.samsung.sodam.api.response.QClientListResponse;
import lombok.RequiredArgsConstructor;
=======
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsung.sodam.api.response.ClientListResponse;
import com.samsung.sodam.api.response.QClientListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
=======
import javax.annotation.Nullable;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
import java.util.List;

import static com.samsung.sodam.db.entity.QClient.client;
import static com.samsung.sodam.db.entity.QConsultSession.consultSession;
<<<<<<< HEAD
import static com.samsung.sodam.db.entity.QReview.review;
=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934

@Repository
@RequiredArgsConstructor
public class ClientResponseCustomRepositoryImpl implements ClientResponseCustomRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<ClientListResponse> getAllClientList(String userId, Pageable pageable) {
        List<ClientListResponse> list = queryFactory
                .select(new QClientListResponse(
                        client.id,
                        client.name,
                        client.email,
                        client.tel
                ))
                .from(client).join(consultSession).on(client.id.eq(consultSession.clientId))
                .where(consultSession.counselorId.eq(userId))
                .distinct()
                .orderBy(client.id.desc())
                .fetch();


        return new PageImpl<>(list, pageable, list.size());
    }

<<<<<<< HEAD
//    @Override
//    public Page<ClientListResponse> getClientList(String userId, Pageable pageable) {
//        List<ClientListResponse> list = queryFactory
//                .select(new QClientListResponse(
//                        client.id,
//                        client.name,
//                        client.email,
//                        client.tel
//                ))
//                .from(client).join(consultSession).on(client.id.eq(consultSession.clientId))
//                .where(consultSession.counselorId.eq(userId))
//                .distinct()
//                .orderBy(client.id.desc())
//                .fetch();
//
//
//        return new PageImpl<>(list, pageable, list.size());
//    }
=======
    @Override
    public Page<ClientListResponse> getClientList(String userId, @Nullable String searchWord, Pageable pageable) {
        List<ClientListResponse> list = queryFactory
                .select(new QClientListResponse(
                        client.id,
                        client.name,
                        client.email,
                        client.tel
                ))
                .from(client).join(consultSession).on(client.id.eq(consultSession.clientId))
                .where(consultSession.counselorId.eq(userId),client.name.like("%"+searchWord+"%"))
                .distinct()
                .orderBy(client.id.desc())
                .fetch();


        return new PageImpl<>(list, pageable, list.size());
    }
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
//    private ClientListResponse getClientListResponse(String clientId) {
//        if(clientId == null || client.id.equals("")) return null;
//        return client.id.eq(clientId);
//    }
<<<<<<< HEAD

    @Override
    public List<CounselorListResponse> getReviewByAvg() {
        return queryFactory.from(review).groupBy(review.counselorId).select(
                Projections.bean(
                        CounselorListResponse.class,
                        review.id,
                        review.counselorId,
                        review.stars.avg().as("avg")
                )
        ).fetch();
    }

=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
}
