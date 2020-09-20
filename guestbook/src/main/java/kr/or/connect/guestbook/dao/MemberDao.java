package kr.or.connect.guestbook.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.connect.guestbook.dto.Member;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Member getMemberByEmail(String loginUserId) {
		return sqlSession.selectOne("Member.SELECT_ALL_BY_EMAIL", loginUserId);
	}
	
	public List<Member> getMemberList() {
		return sqlSession.selectList("Member.SELECT_ALL_MEMBER");
	}
	
	
	
	/*
	private NamedParameterJdbcTemplate jdbc;
	// BeanPropertyRowMapper는 Role클래스의 프로퍼티를 보고 자동으로 칼럼과 맵핑해주는 RowMapper객체를 생성한다.
	// roleId 프로퍼티는 role_id 칼럼과 맵핑이 된다.
	// 만약 프로퍼티와 칼럼의 규칙이 맞아 떨어지지 않는다면 직접 RowMapper객체를 생성해야 한다.
	// 생성하는 방법은 아래의 rowMapper2를 참고한다.
	private RowMapper<Member> rowMapper = BeanPropertyRowMapper.newInstance(Member.class);
	private RowMapper<Long> srowMapper = BeanPropertyRowMapper.newInstance(Long.class);

	public MemberDao(DataSource dataSource){
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public Member getMemberByEmail(String email){
		Map<String, Object> map = new HashMap<>();
		map.put("email", email);

		return jdbc.queryForObject(MemberDaoSqls.SELECT_ALL_BY_EMAIL, map, rowMapper);
	}
	
	public String isCanJoinEmail(String email) {
		Map<String, Object> map = new HashMap<>();
		map.put("email", email);
		Member member = jdbc.queryForObject(MemberDaoSqls.IS_CAN_JOIN_EMAIL, map, rowMapper);
		if(member.getEmail() == null) {
			return "Y";
		} else {
			return "N";
		}
		
	}
	public Long getMemberId() {
		Map<String, Object> map = new HashMap<>();
		Long memberId = jdbc.queryForObject(MemberDaoSqls.IS_CAN_JOIN_EMAIL, map, srowMapper);
		System.out.println("memberId = " + memberId);
		return memberId;
	}
	
	public void addMember(Member member) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", member.getId());
		map.put("password", member.getPassword());
		map.put("email", member.getEmail());
		jdbc.update(MemberDaoSqls.INSERT_MEMBER, map);
	}
	public void addMemberRole(Long memberId) {
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", memberId);
		jdbc.update(MemberDaoSqls.INSERT_MEMBER_ROLE, map);
	}
	*/
}
