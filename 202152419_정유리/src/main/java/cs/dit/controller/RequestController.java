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

import cs.dit.domain.Criteria;
import cs.dit.domain.PageDTO;
import cs.dit.domain.RequestVO;
import cs.dit.service.RequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/request")
@RequiredArgsConstructor
@Log4j
public class RequestController {

	private final RequestService service;
	
	//추가요청 목록화면
	@GetMapping("/br_requestList")
	public void list(Criteria cri, Model model) {
		
		int total = service.getTotal(cri);
		
		model.addAttribute("request", service.getList(cri));
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	@PostMapping("/br_requestList")
	public void list_POST(Criteria cri, Model model) {
		
		int total = service.getTotal(cri);
		
		model.addAttribute("request", service.getList(cri));
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	
	//추가요청 상세화면
	@GetMapping("/br_requestDetail")
	public void get(@Param("rNo") int rNo, Model model) {
		
		model.addAttribute("detail", service.get(rNo));
	}

	//요청작성 화면
	@GetMapping("/br_writeRequest")
	public String memWithdrawal(HttpServletRequest request, RedirectAttributes rttr) {
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		//로그인이 되어 있지 않을 경우 로그인창으로 이동
		if(userId == null) {
			rttr.addFlashAttribute("result", "failed");
			return "redirect:/member/br_login";
		}
		//로그인 되어 있는 경우 요청작성 화면으로 이동
		else {
			return "/request/br_writeRequest";
		}
	}
	
	@GetMapping("/register")
	public void registerGET() {
		
	}
	
	
	//추가요청 등록 
	@PostMapping("/register")
	public String register(RequestVO request, RedirectAttributes rttr) {

		if(request.getRname() == "" || request.getRcontent() == "") {
			rttr.addFlashAttribute("result", "error");
			return "redirect:/request/br_writeRequest";
		}
			
		int count = service.register(request);
		
		if(count==1)
			rttr.addFlashAttribute("result", "registered");		//한번만 사용하는 값을 보냄
		
		return "redirect:/request/br_requestList";
	}
}
