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
import cs.dit.domain.ReviewVO;
import cs.dit.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/review")
@RequiredArgsConstructor
@Log4j
public class ReviewController {

	private final ReviewService service;
	
	
	//리뷰 목록 화면
	@GetMapping("/br_reviewList")
	public void list(Criteria cri, Model model) {
		
		int total = service.getTotal(cri);
		
		model.addAttribute("review", service.getList(cri));
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	@PostMapping("/br_reviewList")
	public void list_POST(Criteria cri, Model model) {
		
		int total = service.getTotal(cri);
		
		model.addAttribute("review", service.getList(cri));
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	
	
	//리뷰 상세보기
	@GetMapping("/br_reviewDetail")
	public void get(@Param("rNum") int rNum, Model model) {
		
		model.addAttribute("detail", service.get(rNum));
	}
	
	//리뷰작성 화면
	@GetMapping("/br_writeReview")
	public String memWithdrawal(HttpServletRequest request, RedirectAttributes rttr) {
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		//로그인이 되어 있지 않을 경우 로그인창으로 이동
		if(userId == null) {
			rttr.addFlashAttribute("result", "failed");
			return "redirect:/member/br_login";
		}
		//로그인 되어 있는 경우 리뷰작성 화면으로 이동
		else {
			return "/review/br_writeReview";
		}
	}
	
	
	@GetMapping("/register")
	public void registerGET() {
		
	}
	
	
	//리뷰 등록 
	@PostMapping("/register")
	public String register(ReviewVO review, RedirectAttributes rttr) {

		if(review.getNickName() == "" || review.getBname() == "" || review.getContent() == "") {
			rttr.addFlashAttribute("result", "error");
			return "redirect:/review/br_writeReview";
		}
		
		int count = service.register(review);
		
		if(count==1)
			rttr.addFlashAttribute("result", "registered");		//한번만 사용하는 값을 보냄
		
		return "redirect:/review/br_reviewList";
	}
}
