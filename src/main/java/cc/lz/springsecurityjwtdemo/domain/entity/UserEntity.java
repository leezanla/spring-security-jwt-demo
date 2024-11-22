/**
 * @author leezan
 * @Data 2024/11/20 21:49
 */
package cc.lz.springsecurityjwtdemo.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.HashSet;
import java.util.Set;

@Table(name = "tb_user")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 50, unique = true)
    @NotNull(message = "username不能为null")
    @Size(min = 5, max = 50, message = "用户名必须要大于5或者小于50")
    private String username;

    @Column(name = "password", length = 100)
    @NotNull(message = "用户密码不能为空")
    @Size(min = 8, max = 100, message = "用户密码不能小于8位或大于16位")
    @JsonIgnore
    private String password;

    @Column(name = "email", unique = true)
    @Email
    private String email;

    @Column(name = "activated")
    @NotNull(message = "activated不能为空")
    @JsonIgnore
    private boolean activated = true;

    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    @BatchSize(size = 20)
    private Set<AuthorityEntity> authorities = new HashSet<>();
}
