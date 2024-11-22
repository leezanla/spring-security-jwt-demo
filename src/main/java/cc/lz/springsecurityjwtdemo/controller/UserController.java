/**
 * @author leezan
 * @Data 2024/11/21 14:25
 */
package cc.lz.springsecurityjwtdemo.controller;

import cc.lz.springsecurityjwtdemo.domain.dto.RegisterDto;
import cc.lz.springsecurityjwtdemo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody RegisterDto register) {
        userService.addUser(register);
        return new ResponseEntity("添加成功", HttpStatus.OK);
    }
}
