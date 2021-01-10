package kr.ac.hansung.controller;


import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* @Component를 구체화시켜 @Controller, @Service, @Repository를 사용한다. 
 * 이러면 스프링에게 좀 더 자세한 정보를 줄 수 있음. 
 * @Component는 제네럴한 어노테이션임. 
 */ 
@Controller
public class HomeController {
	
	// 루트쪽으로 리퀘스트가 오면 하단의 home 메소드가 불린다.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home"; //home이라고 하는 view를 리턴한다. home.jsp가 호출된다. 
	}
	
}
