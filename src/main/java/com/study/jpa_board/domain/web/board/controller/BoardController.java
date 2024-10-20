package com.study.jpa_board.domain.web.board.controller;

import com.study.jpa_board.domain.web.board.dto.request.CreateBoardRequestDto;
import com.study.jpa_board.domain.web.board.facade.BoardFacade;
import com.study.jpa_board.domain.web.user.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Board API", description = "게시판 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

  private final BoardFacade boardFacade;

  @PostMapping
  @Operation(summary = "게시글 등록")
  public ResponseEntity<?> createBoard(@RequestBody @Valid CreateBoardRequestDto req,
      HttpSession session) {
    User user = (User) session.getAttribute("user");
    try {

      if (user == null) {
        return ResponseEntity.badRequest().body("로그인이 필요합니다.");
      }

      boardFacade.createBoard(req);
      return ResponseEntity.ok().build();
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
