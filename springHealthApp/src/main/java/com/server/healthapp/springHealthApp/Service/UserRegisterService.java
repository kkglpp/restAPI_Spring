package com.server.healthapp.springHealthApp.Service;

import com.server.healthapp.springHealthApp.dto.UserDto;
import com.server.healthapp.springHealthApp.entity.UserEntity;
import com.server.healthapp.springHealthApp.exception.CustomException;
import com.server.healthapp.springHealthApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserRegisterService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserRegisterService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void registerUser(UserDto userDto) {
        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(userDto.getPassword_hash()); //
        // 사용자 엔티티 생성 및 값 설정
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setPassword_hash(encodedPassword); // 암호화된 비밀번호 저장
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPhone(userDto.getPhone());
        // 데이터베이스에 사용자 저장
        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
            log.info("*********************************");
            log.info(e.getMessage());
            throw e;
        }
        log.info("userEntity저장");
    }

    public void checkUserId(String id) {

        if (userRepository.existsById(id)) {
            throw new CustomException("이미 존재 하는 아이디입니다.");
        }
    }


}//end UserRegisterService
