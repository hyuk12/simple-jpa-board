package com.study.jpa_board.domain.web.user.entity.repository;

import com.study.jpa_board.domain.web.user.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);
}
