/**
 * @author leezan
 * @Data 2024/11/20 22:25
 */
package cc.lz.springsecurityjwtdemo.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDto {
    @NotNull(message = "用户名不能为空")
    @Size(min = 1, max = 50)
    private String username;

    @NotNull(message = "密码不能为空")
    @Size(min = 4, max = 100, message = "密码要大于8少于16位")
    private String password;

    private Boolean rememberMe;
}
