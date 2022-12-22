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
	
	//Q&A ȭ��
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
	
	
	
	
	//���� �� ȭ��
	@GetMapping("/br_questionDetail")
	public void get(@Param("qNo") int qNo, Model model) {
		
		model.addAttribute("detail", service.get(qNo));
	}
	
	//�����ۼ� ȭ��
	@GetMapping("/br_writeQuestion")
	public String memWithdrawal(HttpServletRequest request, RedirectAttributes rttr) {
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		//�α����� �Ǿ� ���� ���� ��� �α���â���� �̵�
		if(userId == null) {
			rttr.addFlashAttribute("result", "failed");
			return "redirect:/member/br_login";
		}
		//�α��� �Ǿ� �ִ� ��� �����ۼ� ȭ������ �̵�
		else {
			return "/question/br_writeQuestion";
		}
	}	
	
	@GetMapping("/register")
	public void registerGET() {
		
	}
	
	
	//���� ��� 
	@PostMapping("/register")
	public String register(QuestionVO question, RedirectAttributes rttr) {

		if(question.getQtitle() == "" || question.getQcontent() == "") {
			rttr.addFlashAttribute("result", "error");
			return "redirect:/question/br_writeQuestion";
		}
		
		int count = service.register(question);
	
		if(count==1)
			rttr.addFlashAttribute("result", "registered");		//�ѹ��� ����ϴ� ���� ����
		
		return "redirect:/question/br_questionList";
	}

}
