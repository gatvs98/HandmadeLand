package com.guilherme.silva.projects.handmadeland.service;

import com.guilherme.silva.projects.handmadeland.interfaces.IUserService;
import com.guilherme.silva.projects.handmadeland.model.User;
import com.guilherme.silva.projects.handmadeland.repository.UserRepository;
import com.guilherme.silva.projects.handmadeland.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "userService")
public class UserService implements UserDetailsService, IUserService {
  private static final Logger log = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;


  public UserDetails loadUserByUsername(String username) {
    Optional<User> user = userRepository.findUserByUsername(username);
    if(!user.isPresent()){
      log.error("Invalid username or password");
      throw new UsernameNotFoundException("Invalid username or password");
    }

    return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), null);
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
}

