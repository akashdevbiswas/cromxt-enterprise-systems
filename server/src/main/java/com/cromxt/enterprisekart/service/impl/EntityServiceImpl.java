package com.cromxt.enterprisekart.service.impl;

import java.util.HashMap;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.cromxt.enterprisekart.dtos.requests.UserCreadentials;
import com.cromxt.enterprisekart.dtos.requests.UserRequest;
import com.cromxt.enterprisekart.dtos.responses.AuthToken;
import com.cromxt.enterprisekart.models.UserModel;
import com.cromxt.enterprisekart.repository.UserRepository;
import com.cromxt.enterprisekart.service.AuthService;
import com.cromxt.enterprisekart.service.EntityMapper;
import com.cromxt.enterprisekart.service.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntityServiceImpl implements AuthService {

  private final UserRepository userRepository;
  private final JwtService jwtService;
  private final EntityMapper entityMapper;
  private final AuthenticationManager authenticationManager;

  @Override
  public void saveUser(UserRequest userRequest) {
    UserModel userModel = entityMapper.createUserModel(userRequest);
    userRepository.save(userModel);
  }

  @Override
  public AuthToken generateToken(UserCreadentials userCreadentials) {
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
        userCreadentials.username(), userCreadentials.password());

    Authentication authentication = authenticationManager.authenticate(authenticationToken);

    UserModel user = (UserModel) authentication.getPrincipal();

    String token = jwtService.generateToken(user.getId(), user.getAuthorities(), new HashMap<>());
    return new AuthToken(token);
  }

}
