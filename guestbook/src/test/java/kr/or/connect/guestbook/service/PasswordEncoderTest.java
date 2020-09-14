package kr.or.connect.guestbook.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.connect.guestbook.config.ApplicationConfig;
import kr.or.connect.guestbook.config.securityConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, securityConfig.class})
public class PasswordEncoderTest {
    @Autowired
    PasswordEncoder passwordEncoder;
    // 인코딩된 값이 나옴
    @Test
    public void passwordEncode() throws Exception{
        System.out.println(passwordEncoder.encode("1234"));
    }
    // 인코딩된 값은 매번 다름
    @Test
    public void passwordTest() throws Exception{
    	String encodePasswd = "$2a$10$dYQ6Q7z0DEeDOTNBNGYMx.NltV6AaHNBjQzOdAJpclxP4NmNkHPZ2";
    	String password = "1234";
    	boolean test = passwordEncoder.matches(password, encodePasswd);
    	System.out.println(test);
    }

}