package com.samsung.sodam.api.controller;

import com.samsung.sodam.api.request.*;
import com.samsung.sodam.api.response.ClientListResponse;
<<<<<<< HEAD
import com.samsung.sodam.api.response.CounselorListResponse;
=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
import com.samsung.sodam.api.service.ClientService;
import com.samsung.sodam.api.service.CounselorRepositoryService;
import com.samsung.sodam.api.service.ReviewService;
import com.samsung.sodam.db.entity.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
=======
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CounselorController {

    private final CounselorRepositoryService service;
    private final ClientService clientService;

    private final ReviewService reviewService;

    public CounselorController(CounselorRepositoryService service, ClientService clientService, ReviewService reviewService) {
        this.service = service;
        this.clientService = clientService;
        this.reviewService = reviewService;
    }

    //상담사 검색(목록 보기) 다른 필터링 요소 추가해야함.
//    @PostMapping("counselor/")
//    public Page<Counselor> searchCounselor(CounselorSearchRequest request, @PageableDefault(value = 10) Pageable pageable) {
//        return service.searchCounselor(request, pageable);
//    }

<<<<<<< HEAD
    @ApiOperation(value = "모든 상담사를 조회")
    @PostMapping("counselor/")
    public Page<Counselor> searchCounselor() {
        Pageable pageable = Pageable.ofSize(20);
        //service.getAllCounselor(pageable);
        String str = "dd";
        ArrayList<CONSULT_TYPE> conlist = new ArrayList<>();
        conlist.add(CONSULT_TYPE.COURSE);
        List<Counselor> list = new ArrayList<>();

        Counselor c = Counselor.builder()
                .email("email")
                .name("name")
                .id("string")
                .tel("telll")
                .consultTypeList(conlist)
                .gender(GENDER.MEN)
        .build();
        c.setRoleByCommonCode();
        list.add(c);
        list.add(c);
        list.add(c);
        list.add(c);
        list.add(c);
        list.add(c);
        Page<Counselor> result = new PageImpl<>(list);

        return result;
=======
    //상담사 검색(목록 보기) 다른 필터링 요소 추가해야함.
    @PostMapping("counselor/")
    public Page<Counselor> searchCounselor(CounselorSearchRequest request, @PageableDefault(value = 10) Pageable pageable) {
        return service.searchCounselor(request, pageable);
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
    }

    @ApiOperation(value = "상담사의 상세 정보를 조회")
    @GetMapping("counselor/{id}")
    //상담사 정보 조회
    public CounselorListResponse getCounselorInfo(@PathVariable String id) {
        return service.getCounselorDetail(id);
    }

    @PutMapping(value = "/counselor/{id}")
    @ApiOperation(value="상담사 정보 수정", notes="상담사 정보 수정 - email, 전화번호, 학력, 경력")
    public HttpStatus editProfilecCounselor(@PathVariable String id, @RequestBody CounselorRequest request) {
        try {
            System.out.println("editProfileCounselor - parameter test");
            System.out.println(request.getConsultType());
            System.out.println(Arrays.toString(request.getRoutine()));
            service.editProfile(request, id);
            return HttpStatus.OK;
        } catch(Exception e){
            e.printStackTrace();
            return HttpStatus.NOT_FOUND;
        }
    }

    @PutMapping(value = "/counselor/test")
    @ApiOperation(value="테스트")
    public HttpStatus setCounselorType( String clientId, @RequestBody TestRequest request) {
        try {
            System.out.println(request.getList().toString());
            service.counselorTest(request, clientId);
            return HttpStatus.OK;
        } catch(Exception e){
            e.printStackTrace();
            return HttpStatus.NOT_FOUND;
        }
    }

    //상담 예약
    @PostMapping("/consult")
    @ApiOperation(value = "상담 예약")
    public void makeNewSchedule(ConsultSchedule schedule) {
        service.makeNewSchedule(schedule);
    }

    //상담 예약 확정
    @PostMapping("/consult/{consult_id}")
    public Integer acceptApplicant(@PathVariable String consult_id, @RequestBody SessionStateRequest request) {
        service.acceptApplicant(request);
        return request.getSessionId();
    }

    //관심 상담사 담기
    @PostMapping("/client/{clientId}/fav/{counselorId}")
    @ApiOperation(value = "관심상담사 등록")
<<<<<<< HEAD
    public String setFavCounselor(@PathVariable String clientId, @PathVariable String counselorId) {
=======
    public void setFavCounselor(@PathVariable String clientId, @PathVariable String counselorId) {
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
        FavoriteCounselor fav = new FavoriteCounselor(clientId, counselorId);
        service.setFavCounselor(fav);
        return "success";
    }

    //관심 상담사 담기
    @PostMapping("/fav/{clientId}")
    @ApiOperation(value = "관심상담사 조회")
    public List<CounselorListResponse> getMyFavCounselor(@PathVariable String clientId) {
        return service.getMyFavCounselor(clientId);
    }

    @DeleteMapping("/client/{clientId}/fav/{counselorId}")
    @ApiOperation(value = "관심상담사 삭제")
<<<<<<< HEAD
    public String deleteFavCounselor(@PathVariable String clientId, @PathVariable String counselorId) {
=======
    public void deleteFavCounselor(@PathVariable String clientId, @PathVariable String counselorId) {
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
        FavoriteCounselor fav = new FavoriteCounselor(clientId, counselorId);
        service.removeFavCounselor(fav);
        return "success";
    }

    //상담기록(한 세션에 대한 기록)
    @GetMapping("/client/{id}/consult")
    public Page<ConsultSchedule> getHistory(Pageable pageable, @PathVariable Integer id) {
        return service.getHistory(id, pageable);
    }

    //상담세션 만들기
    @PostMapping("/consult-session")
<<<<<<< HEAD
    @ApiOperation(value = "상담 세션 만들기(관리자)")
=======
    @ApiOperation(value = "상담 세션 만들기")
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
    public Integer makeSession(ConsultSession session) {
        return service.makeSession(session);
    }

    //상담세션 조회
    @GetMapping("/consult-session")
<<<<<<< HEAD
    @ApiOperation(value = "나의 상담 세션 조회하기(상담사)")
=======
    @ApiOperation(value = "나의 상담 세션 조회하기")
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
    public List<ConsultSession> mySession(String counselorId) {
        return service.getMySession(counselorId);
    }


    @GetMapping("/client")
    @ApiOperation(value = "모든 고객 목록 조회(관리자용)")
    //고객목록
    public Page<Client> getClients(@PathVariable Pageable pageable) {
        return service.getAllClients(pageable);
    }

<<<<<<< HEAD
    @GetMapping(value = { "/myclient/{consultantId}"})
    @ApiOperation(value = "고객 목록 조회(삭제예정)")
    //고객목록
    public Page<ClientListResponse> getClients(@PathVariable String consultantId) {
        return clientService.getMyClients(consultantId, Pageable.ofSize(20));
    }

//    @GetMapping(value = { "/client/{consultantId}"})
//    @ApiOperation(value = "고객 목록 조회")
//    //고객목록
//    public Page<ClientListResponse> getClients(@PathVariable String consultantId, @PathVariable(name = "keyword") Optional<String> keyword) {
//        return clientService.getMyClients(consultantId, keyword.orElse(""), Pageable.ofSize(20));
//    }
=======
    @GetMapping("/client/{consultantId}/{keyword}")
    @ApiOperation(value = "고객 목록 조회")
    //고객목록
    public Page<ClientListResponse> getClients(@PathVariable String consultantId, @PathVariable(required = false) String keyword) {
        return clientService.getMyClients(consultantId, keyword, Pageable.ofSize(20));
    }
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934

    //일정 상세 정보

    //상담 결과지

    //최초 상담 신청
    @PostMapping("/consultApplicant")
    @ApiOperation(value = "상담예약신청")
    public ConsultApplicant makeConsultApplicant(@RequestBody ConsultApplicantRequest request) {
        return service.makeApplicant(request);
    }

    @PostMapping("/consult-session/{consult_id}")
    @ApiOperation(value = "고객이 상담신청서를 작성한 경우 상담 요청 상태 변경")
    public void setApplicantSessionState(@RequestBody SetStateRequest request, @PathVariable String consult_id) {
<<<<<<< HEAD
        service.setApplicationState(request,consult_id);
=======
        service.setApplicationState(request);
    }


    //상담사의 후기 목록 보기
    @PostMapping("/review/my")
    @ApiOperation(value = "고객이 작성한 나의 후기 목록 보기")
    public Page<Review> getAllMyReviews(@RequestBody ReviewRequest request,@PageableDefault(size=20, sort="id") Pageable pageable) {
        return reviewService.getAllMyReviews(request,pageable);
    }

    //내가 작성한 후기 목록 보기
    @GetMapping("/review/my")
    @ApiOperation(value = "내가 작성한 후기 목록 보기")
    public List<Review> getReviews(String clientId) {
        return reviewService.getMyReview(clientId);
    }

    @PostMapping("/review")
    @ApiOperation(value = "리뷰 작성하기")
    public Review makeReview(@RequestBody Review review){
        return reviewService.makeReview(review);
    }

    @PostMapping("/review/{reviewId}")
    @ApiOperation(value = "리뷰 수정하기")
    public Review updateReview(@PathVariable Long reviewId, @RequestBody Review review){
        return reviewService.updateReview(reviewId,review);
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
    }



<<<<<<< HEAD


=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
}
