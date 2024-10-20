package com.study.jpa_board.domain.web.board.entity.repository;

import com.study.jpa_board.domain.web.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
