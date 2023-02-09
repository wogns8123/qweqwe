package com.samsung.sodam.api.service;

<<<<<<< HEAD
import com.samsung.sodam.api.request.*;
import com.samsung.sodam.api.response.CounselorListResponse;
=======
import com.samsung.sodam.api.request.ConsultApplicantRequest;
import com.samsung.sodam.api.request.CounselorSearchRequest;
import com.samsung.sodam.api.request.SessionStateRequest;
import com.samsung.sodam.api.request.SetStateRequest;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
import com.samsung.sodam.db.entity.*;
import com.samsung.sodam.db.repository.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
import java.util.List;

@Service
@AllArgsConstructor
@Setter
@Getter
public class CounselorRepositoryService {

    @Autowired
    SessionRepository sessionRepository;
    CounselorRepository repository;
<<<<<<< HEAD

    CounselorCustomRepository counselorCustomRepository;
    ScheduleRepository scheduleRepository;

    ApplicantCustomRepository applicantCustomRepository;
=======
    ScheduleRepository scheduleRepository;

>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
    ApplicantRepository applicantRepository;
    FavoriteRepository favoriteRepository;
    ClientRepository clientRepository;

<<<<<<< HEAD
    final AuthService authService;

//    public Page<Counselor> searchCounselor(CounselorSearchRequest request, Pageable pageable) {
//        return repository.find;
//    }
=======
    public Page<Counselor> searchCounselor(CounselorSearchRequest request, Pageable pageable) {
        return repository.findAll(pageable);
    }
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934

    public Page<Counselor> getAllCounselor( Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Counselor getCounselorInfo(String id) {
        return repository.getById(id);
    }
<<<<<<< HEAD
    public Long counselorTest(TestRequest request, String id) {
//        System.out.println("service :: "+request.getList().toString());
//        System.out.println("service :: "+request.getList().getClass());
//        return counselorCustomRepository.updateType(request,id);
        return null;
    }
=======

//    public List<Review> getReviews(String id) {
//        return reviewRepository.findAllByClientId(id);
//    }
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934


    // 파일 제외 수정임
    public void editProfile(CounselorRequest request, String id){

        Counselor counselor = repository.getById(id);
        // 전화번호 수정
        if(request.getTel() != null) counselor.setTel(request.getTel());

        // 이메일 수정
        if(request.getEmail() != null) {
            authService.validateDuplicateEmail(request.getEmail());
            counselor.setEmail(request.getEmail());
        }

        // 소개 수정
        if(request.getIntroduce()!= null) {
            counselor.setIntroduce(request.getIntroduce());
        }
        // 경력 수정
        if(request.getCareers() != null){
            counselor.setCareer(request.getCareers());
        }

        if(!request.getConsultType().isEmpty()){
            counselor.setConsultTypeList(request.getConsultType());
        }
        System.out.println(counselor.getConsultTypeList().toString());

        repository.save(counselor);
    }

    public CounselorListResponse getCounselorDetail(String id) {
        return counselorCustomRepository.getCounselorDetail(id);
    }

//    public List<Review> getReviews(String id) {
//        return reviewRepository.findAllByClientId(id);
//    }

    public Page<Client> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

//    public Page<Client> getMyClients(Pageable pageable,String id) {
//        Specification
//        return clientRepository.findAll();
//    }

    public Page<ConsultSchedule> getHistory(Integer id, Pageable pageable) {
        return scheduleRepository.getAllBySessionId(id, pageable);
    }

    public void setFavCounselor(FavoriteCounselor favoriteCounselor) {
        favoriteRepository.save(favoriteCounselor);
    }

    public List<CounselorListResponse> getMyFavCounselor(String clientId) {
        return counselorCustomRepository.getMyFavCounselor(clientId);
    }


    public void removeFavCounselor(FavoriteCounselor favoriteCounselor) {
        favoriteRepository.delete(favoriteCounselor);
    }

    public Integer makeSession(ConsultSession session) {
        ConsultSession newSession = sessionRepository.save(session);
        return newSession.getId();
    }

<<<<<<< HEAD
    public List<ConsultSession> getMySession(String counselorId) {
=======
    public List<ConsultSession> getMySession(String counselorId){
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
        return sessionRepository.findByCounselorId(counselorId);
    }

    public ConsultSchedule makeNewSchedule(ConsultSchedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public void acceptApplicant(SessionStateRequest request) {
        ConsultApplicant applicant = applicantRepository.findById(request.getSessionId()).orElseGet(ConsultApplicant::new);
        applicant.setState(request.getState());
        applicantRepository.save(applicant);
    }

    /**
     * @param request
     * @return applicant : 생성된 상담신청서
     * 상담신청을 하면 상담세션과 상담신청서가 생성된다.
     * 상담세션과 상담신청서 id는 동일
     */
    @Transactional
    public ConsultApplicant makeApplicant(ConsultApplicantRequest request) {
        ConsultSession session = ConsultSession.builder()
                .counselorId(request.getCounselorId())
                .clientId(request.getClientId())
                .status(STATE.WAIT)
                .build();

        ConsultSession newSession = sessionRepository.save(session);

        ConsultApplicant applicant = ConsultApplicant.builder()
                .name(request.getName())
                .email(request.getEmail())
                .tel(request.getTel())
                .age(request.getAge())
                .content(request.getContent())
                .dueDate(request.getDueDate())
                .gender(request.getGender())
                .createdDateTime(LocalDateTime.now())
                .turn(0)
                .state(request.getState())
                .isConsult("N")
                .sessionId(newSession.getId())
                .consultType(request.getConsultType())
                .build();

        return applicantRepository.save(applicant);
    }

    /**
     * @param request
     * @return applicant : 수락/거절할 상담요청
     * 상담신청을 하면 상담세션과 상담신청서가 생성된다.
     */
    @Transactional
<<<<<<< HEAD
    public void setApplicationState(SetStateRequest request,String consultantId) {
        ConsultSession session = sessionRepository.getReferenceById(request.getSessionId());
        if(session==null) return;
        session.setStatus(request.getState());
        sessionRepository.flush();

        ConsultApplicant applicant = applicantCustomRepository.getApplicants(consultantId,request.getSessionId());
        if(applicant==null) return;
//        applicantRepository.getReferenceById(request.getSessionId());
        applicant.setState(request.getState());
        applicantRepository.flush();

=======
    public void setApplicationState(SetStateRequest request){
        ConsultSession session = sessionRepository.getReferenceById(request.getSessionId());
        session.setStatus(request.getState());
        sessionRepository.save(session);
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
    }


}
