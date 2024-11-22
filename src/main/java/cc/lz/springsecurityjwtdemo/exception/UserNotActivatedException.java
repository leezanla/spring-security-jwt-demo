/**
 * @author leezan
 * @Data 2024/11/21 14:59
 */
package cc.lz.springsecurityjwtdemo.exception;

import org.springframework.security.core.AuthenticationException;

public class UserNotActivatedException extends AuthenticationException {

   private static final long serialVersionUID = -1126699074574529145L;

   public UserNotActivatedException(String message) {
      super(message);
   }
}