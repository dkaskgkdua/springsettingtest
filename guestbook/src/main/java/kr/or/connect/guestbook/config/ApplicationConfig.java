package kr.or.connect.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
// 비즈니스 로직을 위한 Config
@Configuration
@ComponentScan(basePackages = {"kr.or.connect.guestbook.service"})
@Import({DBConfig.class}) // dao, service에서 수행될 때 DB에 접근을 해야하니 가져다 쓴다.
public class ApplicationConfig {

}
