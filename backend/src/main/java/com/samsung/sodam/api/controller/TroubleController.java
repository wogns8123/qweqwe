package com.samsung.sodam.api.controller;

import com.samsung.sodam.api.request.TroubleCommentRequest;
import com.samsung.sodam.api.request.TroubleRequest;
import com.samsung.sodam.api.response.TroubleOneResponse;
import com.samsung.sodam.api.response.TroubleResponse;
import com.samsung.sodam.api.service.TroubleServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trouble")
public class TroubleController {

    private final TroubleServiceImpl service;

    public TroubleController(TroubleServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/list")
    @ApiOperation(value="고민게시판 전체목록", notes="로그인 여부와 상관없이 고민게시판 전체목록 조회")
    public ResponseEntity<Page<TroubleResponse>> getAllTroubleList(Pageable pageable,
                                                                   @RequestParam(value = "searchword", required = false) String searchWord ) {
        try {
            Page<TroubleResponse> list = service.getAllTroubleList(searchWord, pageable);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(value = "/list/{category}")
    @ApiOperation(value="카테고리별 고민게시판 목록", notes="로그인 여부와 상관없이 카테고리별 고민게시판 전체목록 조회")
    public ResponseEntity<Page<TroubleResponse>> getTroubleList(@PathVariable String category, Pageable pageable,
                                                                   @RequestParam(value = "searchword", required = false) String searchWord ) {

        try {
            Page<TroubleResponse> list = service.getTroubleList(category, searchWord, pageable);
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping(value = "/writing")
    @ApiOperation(value="고민게시글 작성", notes="내담자만 고민게시글 작성")
    public ResponseEntity<HttpStatus> saveTrouble(@RequestBody TroubleRequest dto) {

        try {
            service.saveTrouble(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="고민게시글 상세보기", notes="하나의 고민게시글에 대한 상세정보")
    public ResponseEntity<TroubleOneResponse> getTrouble(@PathVariable Long id, @AuthenticationPrincipal UserDetails user) {

        try {
<<<<<<< HEAD
            String userId = "";
            if(user != null)
                userId = user.getUsername();

            TroubleOneResponse troubleDetail = service.getTrouble(userId, id);
=======
//            String userId = "";
//            if(user != null)
//                userId = user.getUsername();

            TroubleOneResponse troubleDetail = service.getTrouble("id", id);
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
            return new ResponseEntity<>(troubleDetail, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value="고민게시글 수정", notes="작성자(내담자)만 고민게시글 수정")
    public ResponseEntity<HttpStatus> updateTrouble(@PathVariable Long id, @RequestBody TroubleRequest dto) {

        try {
            service.updateTrouble(id, dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value="고민게시글 삭제", notes="작성자(내담자)만 고민게시글 삭제")
    public ResponseEntity<HttpStatus> deleteTrouble(@PathVariable Long id) {

        try {
            service.deleteTrouble(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(value="/my-trouble")
    @ApiOperation(value="고민게시글 내글보기", notes="내가 작성한 고민게시글 목록")
    public ResponseEntity<Page<TroubleResponse>> getMyTroubleList(Pageable pageable, @AuthenticationPrincipal UserDetails user) {

        try {
<<<<<<< HEAD
            String userId = "";
            if(user != null)
                userId = user.getUsername();

            Page<TroubleResponse> list = service.getMyTroubleList(userId, pageable);
=======
//            String userId = "";
//            if(user != null)
//                userId = user.getUsername();

            Page<TroubleResponse> list = service.getMyTroubleList("id", pageable);
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/comment")
    @ApiOperation(value="고민게시글 댓글 작성", notes="상담사가 댓글 작성")
    public ResponseEntity<HttpStatus> saveComment(@RequestBody TroubleCommentRequest request) {

        try {
            service.saveComment(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping(value = "/comment/{id}")
    @ApiOperation(value="고민게시글 댓글 수정", notes="작성자(상담사)가 댓글 수정")
    public ResponseEntity<HttpStatus> updateComment(@PathVariable Long id, @RequestBody TroubleCommentRequest request) {

        try {
            service.updateComment(id, request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping(value = "/comment/{id}")
    @ApiOperation(value="고민게시글 댓글 삭제", notes="작성자(상담사)가 댓글 삭제")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable Long id) {

        try {
            service.deleteComment(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping(value = "/comment/{id}")
    @ApiOperation(value="고민게시글 댓글 좋아요", notes="내담자가 상담사의 댓글에 좋아요 등록 및 삭제")
    public ResponseEntity<HttpStatus> commentLike(@PathVariable Long id, @RequestBody TroubleCommentRequest request) {

        try {
            service.commentLike(id, request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
