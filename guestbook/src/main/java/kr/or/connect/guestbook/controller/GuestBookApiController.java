package kr.or.connect.guestbook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.guestbook.dto.Member;
import kr.or.connect.guestbook.service.MemberService;

//@RestController
//@RequestMapping(path="/members")
public class GuestBookApiController {
    // 스프링 컨테이너가 생성자를 통해 자동으로 주입한다.
    /*
	private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    public GuestBookApiController(MemberService memberService, PasswordEncoder passwordEncoder){
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }
    
    @GetMapping
    public Map<String, Object> list(@RequestParam(name="start", required=false, defaultValue="0") int start) {
    	List<Member> list = memberService.getUserList();
    	Map<String, Object> map = new HashMap<>();
    	map.put("list", list);
    	
    	return map;
    }*/
}
