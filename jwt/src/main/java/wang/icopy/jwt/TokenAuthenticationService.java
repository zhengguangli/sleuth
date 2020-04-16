package wang.icopy.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/** @author lizhengguang */
public class TokenAuthenticationService {
  static final long EXPIRATIONTIME = 432_000_000;
  static final String SECRET = "P@ssw02d";
  static final String TOKEN_PREFIX = "Bearer";
  static final String HEADER_STRING = "Authorization";

  static void addAuthentication(HttpServletResponse response, String username) {
    String JWT =
        Jwts.builder()
            .claim("authorities", "ROLE_ADMIN,AUTH_WRITE")
            .setSubject(username)
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
            .signWith(SignatureAlgorithm.HS512, SECRET)
            .compact();

    response.setContentType("application/json");
    response.setStatus(HttpServletResponse.SC_OK);
    try {
      response.getOutputStream().println(JSONResult.fillResultString(0, "", JWT));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static Authentication getAuthentication(HttpServletRequest request) {
    String token = request.getHeader(HEADER_STRING);
    if (token != null) {
      Claims claims =
          Jwts.parser()
              .setSigningKey(SECRET)
              .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
              .getBody();
      String user = claims.getSubject();
      List<GrantedAuthority> authorities =
          AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
      return user == null ? new UsernamePasswordAuthenticationToken(user, null, authorities) : null;
    }
    return null;
  }
}
