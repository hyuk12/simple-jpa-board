package com.study.jpa_board.domain.web.board.service;

import com.study.jpa_board.domain.web.board.dto.request.CreateBoardRequestDto;
import com.study.jpa_board.domain.web.board.entity.repository.BoardRepository;
import com.study.jpa_board.domain.web.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateBoardService {
  private final BoardRepository boardRepository;

  public void createBoard(CreateBoardRequestDto requestDto, User user) {
    boardRepository.save(requestDto.of(user));
  }

}
