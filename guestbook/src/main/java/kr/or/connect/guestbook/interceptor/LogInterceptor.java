package kr.or.connect.guestbook.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*  Handler를 실행하기 전, 실행한 후, view를 렌더링한 후 등, Servlet 내에서 메서드에 따라 실행 시점을 다르게 가져감
	- AOP 흉내를 낼 수 있음. HandlerMethod로 메서드 시그니처 등 추가적ㅇ니 정보를 파악해서 로직 실행 여부를 판단 가능
	- View 를 렌더링하기 전에 추가 작업을 할 수 있음.(ex. 권한에 따라 GNB(Global Navigation Bar)항목이 다르게 노출되어야 할때 등 처리하기 좋음
 * */

public class LogInterceptor extends HandlerInterceptorAdapter {
	// controller가 실행된 후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println(handler.toString() + " 가 종료되었습니다.  " + modelAndView.getViewName() + "을 view로 사용합니다.");
	}
	
	// controller가 실행되기 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(handler.toString() + " 를 호출했습니다.");
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		System.out.println("ex : " + ex);
	}
}
