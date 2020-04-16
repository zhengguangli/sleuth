package wang.icopy.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/** @author lizhengguang */
@RestController
@SpringBootApplication
public class JwtApplication {

  public static void main(String[] args) {
    SpringApplication.run(JwtApplication.class, args);
  }

  @GetMapping("/")
  public Map<String, String> hello() {
    Map<String, String> map = new HashMap<>();
    map.put("content", "hello freewolf");
    return map;
  }
}
