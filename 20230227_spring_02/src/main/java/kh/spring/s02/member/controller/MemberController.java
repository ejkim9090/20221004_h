package kh.spring.s02.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.s02.member.model.service.MemberService;
import kh.spring.s02.member.model.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService service;

	@GetMapping("/signUp")
	public ModelAndView viewInsert(ModelAndView mv) {
//		mv.setViewName("member/signUp");
		return mv;
	}
//	@PostMapping("/signUp")
//	TODO
	@GetMapping("/testSignUp")
	public ModelAndView insert(ModelAndView mv			, MemberVo vo) {
		vo.setEmail("emailddd");
		vo.setId("idddd");
		vo.setName("nameddd");
		vo.setPasswd("passwddd");
		int result = service.insert(vo);
		// TODO
		return mv;
	}
	@GetMapping("/update")
	public ModelAndView viewUpdate(ModelAndView mv) {
		return mv;
	}
//	@PostMapping("/update")
//	TODO
	@GetMapping("/testUpdate")
	public ModelAndView update(ModelAndView mv			, MemberVo vo) {
		vo.setEmail("user3333@s.s");
		vo.setPasswd("user333");
		vo.setId("user3");
		service.update(vo);
		return mv;
	}
	@GetMapping("/delete")
	public ModelAndView delete(ModelAndView mv			) {
//		TODO
		String id = "idddd";
		service.delete(id);
		return mv;
	}
	@GetMapping("/info")
	public ModelAndView selectOne(ModelAndView mv			) {
//		TODO
		String id = "user3";
		MemberVo result = service.selectOne(id);
		return mv;
	}
	@GetMapping("/list")
	public ModelAndView selectList(ModelAndView mv) {
		List<MemberVo> result = service.selectList();
		return mv;
	}
	
}
