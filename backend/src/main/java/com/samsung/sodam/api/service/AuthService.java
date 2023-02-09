package com.samsung.sodam.api.service;

import com.samsung.sodam.api.request.AuthCommonRequest;
import com.samsung.sodam.api.request.ClientRequest;
import com.samsung.sodam.api.request.CounselorRequest;
import com.samsung.sodam.api.response.AuthCommonResponse;
import com.samsung.sodam.db.entity.Client;
import com.samsung.sodam.db.entity.Counselor;
import com.samsung.sodam.db.entity.Member;
<<<<<<< HEAD
import com.samsung.sodam.jwt.TokenDto;
=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934


public interface AuthService {
    /**
     * 고객 회원가입
     * @author nuri
     * @param request id, password, name, tel, email
     * @return
     * */
    Client clientSignup(ClientRequest request);

    /**
     * 로그인 (client, counselor, admin)
     * @author nuri
     * @param request id, password
     * @param isKakaoLogin 카카오로그인인지 check
     * @return
     * */
    AuthCommonResponse login(AuthCommonRequest request, Boolean isKakaoLogin);
<<<<<<< HEAD
    void logout(String id);
=======
>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934

    void validateDuplicateId(String id);

    /**
     * 중복 이메일 확인
     * @author nuri
     * @param email
     * */
    void validateDuplicateEmail(String email);
    
    /**
     * 상담사 회원가입
     *
     * @param request
     * @author nuri
     */
    Counselor counselorSignup(CounselorRequest request);

    /**
     * email로 유저 정보 가져오기
     *
     * @param email
     * @author nuri
     */
    public Member getMemberByEmail(String email);

<<<<<<< HEAD
    public Member getMemberById(String id);

    public void updatePassword(String id, String pw);

    TokenDto reissue(String refreshToken);

    void deleteMember(String id);

    void confirmPassword(String id, String password);
=======
    public void updatePassword(String id, String pw);

>>>>>>> d12fddc2c2a750722d3708ace731ee6838a84934
}
