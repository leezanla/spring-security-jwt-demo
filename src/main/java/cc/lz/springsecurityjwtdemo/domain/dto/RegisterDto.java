/**
 * @author leezan
 * @Data 2024/11/21 15:14
 */
package cc.lz.springsecurityjwtdemo.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {
    private String username;
    private String password;
    private String email;
}
