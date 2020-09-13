package kr.or.connect.guestbook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration  // 설정
@EnableWebMvc // 기본적인 것 자동 설정
@ComponentScan(basePackages = {"kr.or.connect.guestbook.controller"}) // 스캔시키기
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter{
	//dispatcherServlet이 읽어들일 대상들
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// url 요청이 아래 경로로 들어오면 우측 Location 경로로 읽어오도록 설정하는 것 매핑
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// default servlet handler를 사용할 수 있게 설정
		// 매핑 정보가 없는 URL 요청이 들어왔을 때 DefaultServletHttpRequestHandler 가 처리하도록 해주는 것
		configurer.enable();
	}
	// 특정 URL에 대한 처리를 컨트롤러 클래스를 작성하지 않고 매핑할 수 있도록 해주는 부분임
	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		System.out.println("addViewControllers가 호출됩니다. ");
		registry.addViewController("/").setViewName("index");
	}
	
	//resolver 에다가 Prefix랑 Suffix를 지정하게 함으로써 적절하게 경로 세팅 /WEB-INF/views/ ????.jsp
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
