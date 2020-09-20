package kr.or.connect.guestbook.dao;

public class MemberDaoSqls {
	public static final String SELECT_ALL_BY_EMAIL = "SELECT id, name, password, email, create_date, modify_date FROM member WHERE email = :email";
	public static final String INSERT_MEMBER = "insert into springbootToy.member (id, name, password, email, create_date, modify_date) values ( :id, '사용자', :password, :email, now(), now())";
	public static final String IS_CAN_JOIN_EMAIL = "select email from member where email = :email";
	public static final String INSERT_MEMBER_ROLE = "insert into springbootToy.member_role (id, member_id, role_name) values ((select ifnull(max(id),0)+1 from springbootToy.member_role), :memberId, 'ROLE_USER')";
}
