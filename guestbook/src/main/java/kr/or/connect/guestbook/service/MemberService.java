package kr.or.connect.guestbook.service;

import kr.or.connect.guestbook.service.security.UserDbService;
import kr.or.connect.guestbook.service.security.UserEntity;

public interface MemberService extends UserDbService{

	UserEntity getUser(String loginUserId);

}
