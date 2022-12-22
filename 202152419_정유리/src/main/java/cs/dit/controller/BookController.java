package cs.dit.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cs.dit.domain.Criteria;
import cs.dit.domain.PageDTO;
import cs.dit.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
@Log4j
public class BookController {

	private final BookService service;
	
	//도서목록
	@GetMapping("/br_bookList")
	public void list(Criteria cri, Model model) {
		
		int total = service.getTotal(cri);
		
		model.addAttribute("book", service.getList(cri));
		
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}
	
	//도서설명
	@GetMapping("/br_bookExplanation")
	public void get(@Param("bno") int bno, Model model) {
		
		model.addAttribute("book", service.get(bno));
	}
	
	
}
