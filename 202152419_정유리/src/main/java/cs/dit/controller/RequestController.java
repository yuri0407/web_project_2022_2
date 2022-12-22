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
	
	//�߰���û ���ȭ��
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
	
	
	//�߰���û ��ȭ��
	@GetMapping("/br_requestDetail")
	public void get(@Param("rNo") int rNo, Model model) {
		
		model.addAttribute("detail", service.get(rNo));
	}

	//��û�ۼ� ȭ��
	@GetMapping("/br_writeRequest")
	public String memWithdrawal(HttpServletRequest request, RedirectAttributes rttr) {
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		//�α����� �Ǿ� ���� ���� ��� �α���â���� �̵�
		if(userId == null) {
			rttr.addFlashAttribute("result", "failed");
			return "redirect:/member/br_login";
		}
		//�α��� �Ǿ� �ִ� ��� ��û�ۼ� ȭ������ �̵�
		else {
			return "/request/br_writeRequest";
		}
	}
	
	@GetMapping("/register")
	public void registerGET() {
		
	}
	
	
	//�߰���û ��� 
	@PostMapping("/register")
	public String register(RequestVO request, RedirectAttributes rttr) {

		if(request.getRname() == "" || request.getRcontent() == "") {
			rttr.addFlashAttribute("result", "error");
			return "redirect:/request/br_writeRequest";
		}
			
		int count = service.register(request);
		
		if(count==1)
			rttr.addFlashAttribute("result", "registered");		//�ѹ��� ����ϴ� ���� ����
		
		return "redirect:/request/br_requestList";
	}
}
