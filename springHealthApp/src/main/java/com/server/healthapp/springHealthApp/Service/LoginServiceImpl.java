package com.server.healthapp.springHealthApp.Service;

import com.server.healthapp.springHealthApp.dto.JwtTokenInfo;
import com.server.healthapp.springHealthApp.dto.LoginDto;
import com.server.healthapp.springHealthApp.entity.UserEntity;
import com.server.healthapp.springHealthApp.exception.CustomException;
import com.server.healthapp.springHealthApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    private final SampleMapper sampleMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public LoginServiceImpl(SampleMapper sampleMapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.sampleMapper = sampleMapper;
        this.userRepository = userRepository;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.passwordEncoder = passwordEncoder;
    }

    //Login method
    public UserEntity userLogin(LoginDto loginDto) {
        UserEntity user;
        Optional<UserEntity> optionalUser = userRepository.findById(loginDto.getUserId());
        // 사용자 존재 여부 체크
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        } else {
            throw new RuntimeException("Invalid username or password"); //
        }
        //비밀번호 검증
        if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword_hash())) {
            return user;
        }
        throw new RuntimeException("Invalid username or password"); //
    } // end userLogin --검증끝--

    public void saveRefreshToken(String userId, JwtTokenInfo jwtTokenInfo) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException("User not found"));
        userEntity.setRefresh_token(jwtTokenInfo.getRefreshToken()); // refreshToken 설정
        userRepository.save(userEntity); // 변경 사항 저장
    }


}
