/**
 * @author leezan
 * @Data 2024/11/21 15:31
 */
package cc.lz.springsecurityjwtdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AnotherController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }

}
