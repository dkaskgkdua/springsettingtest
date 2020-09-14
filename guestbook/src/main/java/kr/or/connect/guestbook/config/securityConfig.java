package kr.or.connect.guestbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.or.connect.guestbook.service.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    CustomUserDetailsService customUserDetailsService;
	
    //   /webjars/** 경로에 대한 요청은 인증/인가 처리하지 않도록 무시합니다.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/resources/**");
    }

    //   /, /main에 대한 요청은 누구나 할 수 있지만, 
//   그 외의 요청은 모두 인증 후 접근 가능합니다.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/", "/main", "/memembers/loginerror", "/members/joinform", "/members/join", "/members/welcome").permitAll()
        .antMatchers("/securepage", "/members/**").hasRole("USER") // USER 라는 권한이 있어야 하는 URL
        //.antMatchers("/abc/**").hasRole("ADMIN")
        .anyRequest().authenticated()
        .and()
            .formLogin()			// 로그인 폼 세팅
            .loginPage("/members/loginform")  // 로그인 폼 컨트롤러 메서드
            .usernameParameter("userId")		// <input> name 속성이 userId, password 일치하여야 함
            .passwordParameter("password")
            .loginProcessingUrl("/authenticate") // 로그인 프로세스를 처리하는 경로
            .failureForwardUrl("/members/loginerror?login_error=1") // 로그인 실패했을 경우 포워딩 경로
            .defaultSuccessUrl("/",true)		// 로그인 성공시 포워딩 경로
            .permitAll()						// 로그인 폼은 누구나 접근가능
        .and()
            .logout()
            .logoutUrl("/logout")				// 로그아웃 경로
            .logoutSuccessUrl("/");				// 로그아웃 성공시 경로
              

    }
    // authentication filter가 id, password 입력 후 로그인 시 처리해주는 필터
    // UserDetailsService 인터페이스를 구현한 구현체를 이용함
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }
    // 패스워드 인코더를 빈으로 등록합니다. 암호를 인코딩하거나, 
    // 인코딩된 암호와 사용자가 입력한 암호가 같은 지 확인할 때 사용합니다.
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}