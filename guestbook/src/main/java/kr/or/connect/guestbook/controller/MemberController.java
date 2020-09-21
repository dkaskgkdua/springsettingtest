package kr.or.connect.guestbook.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.or.connect.guestbook.argumentresolver.HeaderInfo;
import kr.or.connect.guestbook.dto.Member;
import kr.or.connect.guestbook.service.MemberService;
//http://localhost:8088/connect/swagger-ui.html#/
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
    
    @ApiOperation(value="회원리스트") // swagger 설명
    @ApiResponses({  // 응답 메시지에 대한 설명
    	@ApiResponse(code=200, message = "OK"),
    	@ApiResponse(code=500, message = "Exception")
    })
    @GetMapping("/ex")
    @ResponseBody
    public Map<String, Object> list(@RequestParam(name="start", required=false, defaultValue="0") int start,
    		HeaderInfo headerInfo) {
    	List<Member> list = memberService.getUserList();
    	Map<String, Object> map = new HashMap<>();
    	map.put("list", list);
    	System.out.println("-----------------------------------------------------");
		System.out.println(headerInfo.get("user-agent"));
		System.out.println("-----------------------------------------------------");
    	
    	return map;
    }
    /*
    @PostMapping
    public Member write(@RequestBody Member member, HttpServletRequest request) {
    	String clientIp = request.getRemoteAddr();
    	Member member = memberService.addMember(member, clientIp);
    	return member;
    }
    
    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable(name ="id") Long id, HttpServletRequest request) {
    	String clientIp = request.getRemoteAddr();
    	int deleteCount = memberService.deleteMember(id, clientIp);
    	return Collections.singletonMap("success", deleteCount > 0 ? "true" : "false");
    }
    */
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