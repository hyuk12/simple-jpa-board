package com.study.jpa_board.domain.web.board.entity;

import com.study.jpa_board.domain.web.user.entity.User;
import com.study.jpa_board.global.entity.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "boards")
public class Board extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String content;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Board changeBoard(String title, String content) {
    this.title = title;
    this.content = content;
    return this;
  }
}
