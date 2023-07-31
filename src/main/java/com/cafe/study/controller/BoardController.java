package com.cafe.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	/*@Autowired
	private BoardService brdService;

	@RequestMapping("/list.do")
	public String list(Model model, Common common) {		
		List<Board> list  = brdService.getBoardList(common);
		
		model.addAttribute("section", common.getSection());
		model.addAttribute("pageNum", common.getPageNum());
		model.addAttribute("list", list);
		
		common.setKatNo(1); // 게시판 ID 설정

		//게시판 내용 불러오기
		List<Board> noticelist  = brdService.getBoardList(common);  // 게시판 리스트와 총건수를 받음
		model.addAttribute("noticelist", noticelist); 

		
		if(list.size() > 0)
			model.addAttribute("tot", list.get(0).getTotalCount());

		return "/board/board";
	}
	
	@RequestMapping("/view.do")
	public String view(Model model, @RequestParam("brdNo") int brdNo) {
		brdService.CntUpdate(brdNo);
		Board vo = brdService.getBoardView(brdNo);
		model.addAttribute("info", vo);
		List<Comment> comlist= brdService.getCommentList(brdNo);
		
		model.addAttribute("list", comlist);

		return "/board/view";
	}
	
	@RequestMapping("/save.do")
	public String save(Model model, Board brd) {
		brdService.save(brd);
		return "redirect:/board/list.do";	
	}

	@RequestMapping("/mod.do")
	public String mod(Model model, @RequestParam("brdNo") int brdNo) {
		Board fix = brdService.getBoardView(brdNo);
		model.addAttribute("info", fix);
		
		model.addAttribute("update", fix);
		return "/board/viewmod";
	}

	@RequestMapping("/remove.do")
	public String remove(Model model, @RequestParam("brdNo") int brdNo) {
	    brdService.removeBoard(brdNo);   
	    return "redirect:/board/list.do";	
	}
	
	@RequestMapping("/addReply.do")
	public String remove(Model model, Comment commnect) {
		
		brdService.saveComment(commnect);
		
		model.addAttribute("brdNo", commnect.getBrdNo());
		
	    return "redirect:/board/list.do";	
	}
	

	
	@RequestMapping("/Updatevote.do")
	@ResponseBody
	public Map<String,Integer> updatvodte() {
		Map<String,Integer> map = new HashMap<String, Integer>();
		return map;
	}
	

	*/
}
