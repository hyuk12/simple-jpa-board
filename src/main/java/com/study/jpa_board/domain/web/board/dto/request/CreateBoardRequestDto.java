package com.study.jpa_board.domain.web.board.dto.request;

import com.study.jpa_board.domain.web.board.entity.Board;
import com.study.jpa_board.domain.web.user.entity.User;

public record CreateBoardRequestDto(
    String title,
    String content,
    String email
) {

  public Board of(User user) {
    if (title == null || title.isBlank()) {
      throw new IllegalArgumentException("title must not be null or empty");
    }
    if (content == null || content.isBlank()) {
      throw new IllegalArgumentException("content must not be null or empty");
    }
    if (email == null) {
      throw new IllegalArgumentException("email must not be null");
    }
    return Board.builder()
        .user(user)
        .content(content)
        .title(title)
        .build();
  }
}
