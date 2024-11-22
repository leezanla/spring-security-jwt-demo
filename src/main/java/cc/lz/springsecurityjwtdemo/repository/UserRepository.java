/**
 * @author leezan
 * @Data 2024/11/21 14:26
 */
package cc.lz.springsecurityjwtdemo.repository;


import cc.lz.springsecurityjwtdemo.domain.entity.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @EntityGraph(attributePaths = "authorities")
    Optional<UserEntity> findOneWithAuthoritiesByUsername(String username);

    @EntityGraph(attributePaths = "authorities")
    Optional<UserEntity> findOneWithAuthoritiesByEmailIgnoreCase(String email);
}
