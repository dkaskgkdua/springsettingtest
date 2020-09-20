package kr.or.connect.guestbook.controller;

import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.guestbook.dto.Member;
import kr.or.connect.guestbook.service.MemberService;

@Controller
@RequestMapping(path = "/members")
public class MemberController {
    // 스프링 컨테이너가 생성자를 통해 자동으로 주입한다.
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder){
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/loginform")
    public String loginform(){
        return "members/loginform";
    }

    @GetMapping("/loginerror")
    public String loginerror(@RequestParam("login_error")String loginError){
        return "members/loginerror";
    }

    @GetMapping("/joinform")
    public String joinform(){
        return "members/joinform";
    }
/*
    // 사용자가 입력한 name, email, password가 member에 저장된다.
    @PostMapping("/join")
    public void join(@ModelAttribute Member member, HttpServletResponse response) throws Exception {
    	System.out.println("오나");
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        String msg = memberService.addMember(member, false);
        PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+msg+"');");
		out.println("location.href='/members/loginform';");
		out.println("</script>");
		out.close();
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "members/welcome";
    }
    
    @GetMapping("/memberinfo")
    public String memberInfo(Principal principal, ModelMap modelMap){
    	// 자기정보 가져오는거임
        String loginId = principal.getName();
        System.out.println(loginId);
        Member member = memberService.getMemberByEmail(loginId);
        modelMap.addAttribute("member", member);

        return "members/memberinfo";
    }*/
}