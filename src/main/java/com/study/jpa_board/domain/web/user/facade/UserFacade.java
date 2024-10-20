package com.study.jpa_board.domain.web.user.facade;

import com.study.jpa_board.domain.web.user.service.GetUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

  private final GetUserService getUserService;


}
