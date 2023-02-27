package kh.spring.s02.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@WebServlet("/boardinsert")
public class BoardController {

	@RequestMapping(value = "/boardinsert", method = RequestMethod.GET)
	//@GetMapping("/boardinsert")
	public ModelAndView viewInsertBoard(ModelAndView mv) {
		
		return mv;
	}
	@RequestMapping(value = "/boardinsert", method = RequestMethod.POST)
	//@PostMapping("/boardinsert")
	public ModelAndView doInsertBoard(ModelAndView mv) {
		
		return mv;
	}
	
	
}
