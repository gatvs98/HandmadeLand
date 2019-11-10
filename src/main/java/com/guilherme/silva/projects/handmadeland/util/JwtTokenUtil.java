package com.guilherme.silva.projects.handmadeland.util;

import io.jsonwebtoken.Jwt;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {
  public String getUsernameFromToken(String jwtToken) {
    //TODO
    return "";
  }

  public boolean validateToken(String jwtToken, UserDetails userDetails) {
    //TODO
    return true;
  }
}
