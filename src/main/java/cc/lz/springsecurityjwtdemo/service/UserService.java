/**
 * @author leezan
 * @Data 2024/11/21 14:26
 */
package cc.lz.springsecurityjwtdemo.service;

import cc.lz.springsecurityjwtdemo.domain.dto.RegisterDto;
import cc.lz.springsecurityjwtdemo.domain.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    void addUser(RegisterDto register);

    Optional<UserEntity> getUserWithAuthorities();
}
