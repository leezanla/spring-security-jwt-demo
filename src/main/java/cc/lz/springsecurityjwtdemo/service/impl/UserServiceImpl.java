/**
 * @author leezan
 * @Data 2024/11/21 14:27
 */
package cc.lz.springsecurityjwtdemo.service.impl;

import cc.lz.springsecurityjwtdemo.domain.dto.RegisterDto;
import cc.lz.springsecurityjwtdemo.domain.entity.UserEntity;
import cc.lz.springsecurityjwtdemo.repository.UserRepository;
import cc.lz.springsecurityjwtdemo.service.UserService;
import cc.lz.springsecurityjwtdemo.utils.SecurityUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void addUser(RegisterDto register) {
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(register, user);
        String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserEntity> getUserWithAuthorities() {
        return SecurityUtils.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUsername);
    }
}
