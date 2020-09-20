package kr.or.connect.guestbook.service;

import java.util.List;

import kr.or.connect.guestbook.dto.Member;
import kr.or.connect.guestbook.service.security.UserDbService;
import kr.or.connect.guestbook.service.security.UserEntity;

public interface MemberService extends UserDbService{

	UserEntity getUser(String loginUserId);
	List<Member> getUserList();
	//String addMember(Member member, boolean bool);
	//Member getMemberByEmail(String loginId);
}
