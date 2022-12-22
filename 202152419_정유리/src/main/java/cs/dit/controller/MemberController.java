package cs.dit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs.dit.domain.MemberVO;
import cs.dit.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
@Log4j
public class MemberController {

	private final MemberService service;
	
	@RequestMapping("/br_login")
	public String login() {
		return "/member/br_login";
	}
	
	//회원탈퇴 화면
	@GetMapping("/br_memWithdrawal")
	public String memWithdrawal(HttpServletRequest request, RedirectAttributes rttr) {
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		//로그인이 되어 있지 않을 경우 로그인창으로 이동
		if(userId == null) {
			rttr.addFlashAttribute("result", "failed");
			return "redirect:/member/br_login";
		}
		//로그인 되어 있는 경우 회원탈퇴 화면으로 이동
		else {
			return "/member/br_memWithdrawal";
		}
	}
	
	//회원가입 화면
	@PostMapping("/br_signUp")
	public String signUp() {
		return "/member/br_signUp";
	}
	
	@GetMapping("/br_signUp")
	public String signUp_GET() {
		return "/member/br_signUp";
	}
	
	
	//아이디 중복체크
	@PostMapping("/checkId")
	public String checkId(@Param("id") String id, RedirectAttributes rttr, HttpServletRequest request) {
		
		String check = service.checkId(id);
		HttpSession session = request.getSession();
		
		if(check != null) {
			rttr.addFlashAttribute("result", "idError");
			session.setAttribute("id", id);
			return "redirect:/member/br_signUp";
		}
		else {
			rttr.addFlashAttribute("result", "idSuccess");
			session.setAttribute("id", id);
			return "redirect:/member/br_signUp";
			
		}
	}
	
	
	
	@GetMapping("/register")
	public void registerGET() {
		
	}
	
	
	//회원가입 
	@PostMapping("/register")
	public String register(MemberVO member, RedirectAttributes rttr, HttpServletRequest request) {

		HttpSession session = request.getSession();
		
		if(member.getId() == "" || member.getPwd() == "" || member.getEmail() == "") {
			rttr.addFlashAttribute("result", "error");
			return "redirect:/member/br_signUp";
		}
		
		int count = service.register(member);
		
		if(count==1)
			rttr.addFlashAttribute("result", "registered");		//한번만 사용하는 값을 보냄
		
		session.removeAttribute("id");
		return "redirect:/other/br_main";
	}
	
	
	
	//로그인
	@PostMapping("/login")
	public String login(@Param("id") String id, @Param("pwd") String pwd, HttpServletRequest request, RedirectAttributes rttr) {
		
		HttpSession session = request.getSession();
		
		String check = service.checkUser(id, pwd);
		
		if(check != null) {
			session.setAttribute("userId", id);
			return "redirect:/other/br_main";
		}
		else {
			rttr.addFlashAttribute("result", "notUser");
			return "redirect:/member/br_login";
			
		}
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, RedirectAttributes rttr) {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("userId");
		session.removeAttribute("userName");
		
		rttr.addFlashAttribute("result", "logout");
		
		return "redirect:/other/br_main";
	}
	
	
	//회원탈퇴
	@GetMapping("/remove")
	public String remove(HttpServletRequest request, RedirectAttributes rttr) {
		
		log.info("Controller remove : -----------------------------------------------------------");
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		int count = service.remove(userId);
		
		if(count==1) {
			session.removeAttribute("userId");
			session.removeAttribute("userName");
			rttr.addFlashAttribute("result", "removed");
		}
		
		return "redirect:/other/br_main";
	}
	
}
