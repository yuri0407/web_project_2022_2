package cs.dit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cs.dit.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/other")
@RequiredArgsConstructor
@Log4j
public class OtherController {

	private final BookService service;
	
	//메인화면
	@GetMapping("/br_main")
	public void main(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		
		model.addAttribute("mainBook", service.getList());
	}
	
	@PostMapping("/br_main")
	public void postMain(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		
		model.addAttribute("mainBook", service.getList());
	}
	
}
