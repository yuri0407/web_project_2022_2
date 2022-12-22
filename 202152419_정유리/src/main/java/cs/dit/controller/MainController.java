package cs.dit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs.dit.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
@Controller
public class MainController {
	
	private final BookService service;
	
	//첫 시작 메인화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		
		model.addAttribute("mainBook", service.getList());
		
		return "/other/br_main";
	}
	
}
