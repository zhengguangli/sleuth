package ink.icopy.user.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author lizhengguang */
@RestController
@RequestMapping("/user")
public class UserController {
  @GetMapping("/hi")
  public String hi() {
    return "I'm forezp";
  }
}
