package com.samsung.sodam.db.repository;

<<<<<<< HEAD
import com.querydsl.core.types.Order;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsung.sodam.api.request.ReviewRequest;
import com.samsung.sodam.api.response.CounselorListResponse;
import com.samsung.sodam.db.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
=======
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.samsung.sodam.api.request.ReviewRequest;
import com.samsung.sodam.db.entity.QReview;
import com.samsung.sodam.db.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934

import static com.samsung.sodam.db.entity.QReview.review;

@Repository
public class ReviewCustomRepositoryImpl implements ReviewCustomRepository {
<<<<<<< HEAD
    public final JPAQueryFactory queryFactory;

    public ReviewCustomRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<Review> getAllMyReview(ReviewRequest request, Pageable pageable) {
        List<Review> list = new ArrayList<>();
        if (checkIsNullOrEmpty(request.getClientId()) && (checkIsNullOrEmpty(request.getType()) || request.getType().equals("ALL"))) {
            list = queryFactory.selectFrom(review)
                    .where(review.counselorId.eq(request.getCounselorId())).fetch();
            return new PageImpl<>(list, pageable, list.size());
        } else if (checkIsNullOrEmpty(request.getClientId())) {

            list = queryFactory.selectFrom(review)
                    .where(review.counselorId.eq(request.getCounselorId()),review.type.like(request.getType())).fetch();
            return new PageImpl<>(list, pageable, list.size());
        } else if (checkIsNullOrEmpty(request.getType()) || request.getType().equals("ALL")) {
            list = queryFactory.selectFrom(review)
                    .where(review.counselorId.eq(request.getCounselorId()),review.clientId.like(request.getClientId())).fetch();
            return new PageImpl<>(list, pageable, list.size());
        }


        return new PageImpl<>(list, pageable, 0);
=======
    private JPAQueryFactory queryFactory;

    @Override
    public Page<Review> getAllMyReview(ReviewRequest request, Pageable pageable) {
        List<Review> list = queryFactory.selectFrom(review)
                .where(review.counselorId.eq(request.getCounselorId())).fetch();

        return new PageImpl<>(list, pageable, list.size());
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
    }

    @Override
    public List<Review> getMyReview(String clientId) {
        return queryFactory.selectFrom(review)
                .where(review.clientId.eq(clientId)).fetch();
    }
<<<<<<< HEAD

    @Override
    public List<Review> getReviewByAvg() {
//        return queryFactory.select(review,review.stars.avg().as("average")).from(review).groupBy(review.counselorId).fetch();
//
        return null;
    }


    public boolean checkIsNullOrEmpty(String input) {
        return input == null || input.isEmpty() || input.isBlank();
    }
=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
}
