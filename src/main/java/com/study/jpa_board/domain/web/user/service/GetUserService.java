package com.study.jpa_board.domain.web.user.service;

import com.study.jpa_board.domain.web.user.entity.User;
import com.study.jpa_board.domain.web.user.entity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserService {

  private final UserRepository userRepository;

  public User getUser(Long id) {
    return userRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));
  }

  public User getUserByEmail(String email) {
    return userRepository.findByEmail(email)
        .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다."));
  }
}
