package com.study.jpa_board.domain.web.board.facade;

import com.study.jpa_board.domain.web.board.dto.request.CreateBoardRequestDto;
import com.study.jpa_board.domain.web.board.service.CreateBoardService;
import com.study.jpa_board.domain.web.user.entity.User;
import com.study.jpa_board.domain.web.user.service.GetUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardFacade {

  private final CreateBoardService createBoardService;
  private final GetUserService getUserService;

  public void createBoard(CreateBoardRequestDto req) {
    User userByEmail = getUserService.getUserByEmail(req.email());

    if (userByEmail == null) {
      throw new IllegalArgumentException("해당 사용자가 없습니다.");
    }

    createBoardService.createBoard(req, userByEmail);
  }
}
