package kh.spring.s02.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.spring.s02.member.model.service.MemberService;
import kh.spring.s02.member.model.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService service;

	@GetMapping("/signUp")
	public ModelAndView viewInsert(ModelAndView mv) {
		mv.setViewName("member/signUp");
		return mv;
	}
	@PostMapping("/signUp")
	public ModelAndView insert(ModelAndView mv
			, MemberVo vo
			, String bbb			
			, String id
			, RedirectAttributes rttr
			) {
		int result = -1;
		try {
			result = service.insert(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result > 0) {
			// 회원가입성공
//			 방법 1  - 사용불가방법
//			mv.setViewName("redirect:/?msg=회원가입성공");
//			// 방법 2
//			mv.addObject("msg", "회원가입성공");
//			mv.setViewName("error/errorFailure");
			// 방법 3 - Spring에서만
			rttr.addFlashAttribute("msg", "회원가입성공2");
			mv.setViewName("redirect:/");
		} else {
			// 회원가입실패
			// 방법 3 - Spring에서만
			rttr.addFlashAttribute("msg", "회원가입실패");
			mv.setViewName("redirect:/member/signUp");
		}
		return mv;
	}
	@GetMapping("/update")
	public ModelAndView viewUpdate(ModelAndView mv
			, String id
			) {
		MemberVo vo = service.selectOne(id);
		mv.addObject("membervo", vo);
		mv.setViewName("/member/update");
		return mv;
	}
	@PostMapping("/update")
	public ModelAndView update(ModelAndView mv	
			, MemberVo vo) {
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
	public ModelAndView selectOne(ModelAndView mv
			, String id   // request.getParameter("id")  
			// url " /member/info?id=user3
			// url " /member/info/user3
			) {
		if(id == null) {
			mv.setViewName("redirect:/");
			return mv;
		}
		MemberVo result = service.selectOne(id);
		return mv;
	}
	@GetMapping("/list")
	public ModelAndView selectList(ModelAndView mv) {
		List<MemberVo> result = service.selectList();
		return mv;
	}
	
}
