package wang.icopy.jwt;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;

/** @author lizhengguang */
public class CustomAuthenticationProvider implements AuthenticationProvider {
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String name = authentication.getName();
    String password = authentication.getCredentials().toString();
    if (name.equals("admin") && password.equals("123456")) {

      // 这里设置权限和角色
      ArrayList<GrantedAuthority> authorities = new ArrayList<>();
      authorities.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
      authorities.add(new GrantedAuthorityImpl("AUTH_WRITE"));
      // 生成令牌
      Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
      return auth;
    } else {
      throw new BadCredentialsException("密码错误~");
    }
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return aClass.equals(UsernamePasswordAuthenticationToken.class);
  }
}
