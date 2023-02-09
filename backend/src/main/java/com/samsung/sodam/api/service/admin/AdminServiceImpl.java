package com.samsung.sodam.api.service.admin;

import com.samsung.sodam.api.request.HelpDeskRequest;
import com.samsung.sodam.api.service.NotificationService;
import com.samsung.sodam.db.entity.Notice;
import com.samsung.sodam.db.entity.NotificationType;
import com.samsung.sodam.db.entity.QnAAnswer;
import com.samsung.sodam.db.entity.QnABoard;
import com.samsung.sodam.db.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final NotificationService notificationService;

    private final NoticeRepository noticeRepository;
    private final NoticeCustomRepository noticeCustomRepository;
    private final QnARepository qnARepository;
    private final QnACustomRepository qnACustomRepository;
    private final QnAAnswerRepository qnAAnswerRepository;

    @Override
    public void saveNotice(HelpDeskRequest request) {
        Notice notice = Notice.builder()
                .adminId(request.getWriterId())
                .title(request.getTitle())
                .content(request.getContent())
                .fixed(request.isFixed())
                .build();
        noticeRepository.save(notice);
    }

    @Override
    public Notice getOneNotice(Long id) {
        return noticeRepository.findById(id).get();
    }

    @Override
    public void updateNotice(Long id, HelpDeskRequest request) {
        noticeCustomRepository.updateNotice(id, request);
    }

    @Override
    public void deleteNotice(Long id) {
        noticeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveQnaAnswer(HelpDeskRequest request) {
        Optional<QnABoard> qnABoard = qnARepository.findById(request.getId());

        QnAAnswer qnAAnswer = QnAAnswer.builder()
                .adminId(request.getWriterId())
                .content(request.getContent())
                .qnABoard(qnABoard.orElseThrow(() -> new NoSuchElementException()))
                .build();

        qnAAnswerRepository.save(qnAAnswer);

        notificationService.send(qnABoard.get().getWriterId(), NotificationType.QNA,
                "문의글에 댓글이 등록되었습니다.", "", "/api/qna/" + qnABoard.get().getId());
    }

    @Override
    public void updateQnaAnswer(Long id, HelpDeskRequest request) {
        qnACustomRepository.updateQnaAnswer(id, request);
    }

    @Override
    public void deleteQnaAnswer(Long id) {
        qnAAnswerRepository.deleteById(id);
    }
}
