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
import cs.dit.domain.QuestionVO;
import cs.dit.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
@Log4j
public class QuestionController {
	
	private final QuestionService service;
	
	//Q&A 화면
	@GetMapping("/br_questionList")
	public void list(Criteria cri, Model model) {
		
		int total = service.getTotal(cri);
		
		model.addAttribute("question", service.getList(cri));
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	@PostMapping("/br_questionList")
	public void list_POST(Criteria cri, Model model) {
		
		int total = service.getTotal(cri);
		
		model.addAttribute("question", service.getList(cri));
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	
	
	
	//질문 상세 화면
	@GetMapping("/br_questionDetail")
	public void get(@Param("qNo") int qNo, Model model) {
		
		model.addAttribute("detail", service.get(qNo));
	}
	
	//질문작성 화면
	@GetMapping("/br_writeQuestion")
	public String memWithdrawal(HttpServletRequest request, RedirectAttributes rttr) {
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		//로그인이 되어 있지 않을 경우 로그인창으로 이동
		if(userId == null) {
			rttr.addFlashAttribute("result", "failed");
			return "redirect:/member/br_login";
		}
		//로그인 되어 있는 경우 질문작성 화면으로 이동
		else {
			return "/question/br_writeQuestion";
		}
	}	
	
	@GetMapping("/register")
	public void registerGET() {
		
	}
	
	
	//질문 등록 
	@PostMapping("/register")
	public String register(QuestionVO question, RedirectAttributes rttr) {

		if(question.getQtitle() == "" || question.getQcontent() == "") {
			rttr.addFlashAttribute("result", "error");
			return "redirect:/question/br_writeQuestion";
		}
		
		int count = service.register(question);
	
		if(count==1)
			rttr.addFlashAttribute("result", "registered");		//한번만 사용하는 값을 보냄
		
		return "redirect:/question/br_questionList";
	}

}
