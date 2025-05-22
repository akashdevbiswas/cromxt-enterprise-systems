package com.cromxt.enterprisekart.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cromxt.enterprisekart.dtos.responses.UserResponse;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UsersController {


  @GetMapping
  public ResponseEntity<List<UserResponse>> getAllUsers(){
    return ResponseEntity.ok(List.of(
        new UserResponse("cromxt", "cromxt", "cromxt"),
        new UserResponse("cromxt", "cromxt", "cromxt")
    ));
  }

}
