package com.cafe.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	/*	@Autowired
	private AdminService service;
	
	
	
	
	
//	List<Kategorie> katlist  = service.getMenu();
	
//	request.setAttribute("katlist", katlist); // 메뉴 세팅
	
	
	
//	int katNo = Integer.parseInt(request.getParameter("katNo"));
//	request.setAttribute("katTargetNo", katNo);
//	String KatName = katNo == 1 ? "공지사항" : "회원목록";
//	request.setAttribute("katTargetName", KatName);
	
	
	
//	@RequestMapping("/main.do")
//	public String list() {
//		
//		return "/notice/";
//	}
	
	@RequestMapping("/")
	public void admin(@RequestParam(value="section", required=false) String _section, @RequestParam(value="pageNum", required=false) String _pageNum, Model model) {
				
		//페이징처리
		int section = Integer.parseInt(((_section == null) ? "1" : _section));
		int pageNum = Integer.parseInt(((_pageNum == null) ? "1" : _pageNum));
		
		Map<String,Object> pagingMap = new HashMap<String,Object>();
		pagingMap.put("section", section);
		pagingMap.put("pageNum", pageNum);

		List<Board> list  = service.getBoardList(pagingMap);

		model.addAttribute("section", section);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("list", list);
	}

	@GetMapping("/list.do")
	public String admin_list(@RequestParam(value="section", required=false) String _section, @RequestParam(value="pageNum", required=false) String _pageNum, @RequestParam("katNo") int kateNo, Model model) {
		
		//페이징처리
//		Criteria cri=new Criteria();
//		Kategorie kat=new Kategorie();
		
		int section = Integer.parseInt(((_section == null) ? "1" : _section));
		int pageNum = Integer.parseInt(((_pageNum == null) ? "1" : _pageNum));
		
//		cri.setSection(section);
//		cri.setPageNum(pageNum);
//		kat.setKateNo(kateNo);
		
		Map<String,Object> pagingMap = new HashMap<String,Object>();
		pagingMap.put("section", section);
		pagingMap.put("pageNum", pageNum);
		pagingMap.put("kateNo", kateNo);
		
		List<Board> list  = service.getBoardList(pagingMap);

		model.addAttribute("section", section);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("list", list);
		
		return "/notices/admin_list";
	}
	
	@GetMapping("/memberlist.do")
	public String listmembers(Model model) {
	
		
		model.addAttribute("list", service.getUserList());
		
		return "/member/listMembers";
	}
	
	@GetMapping("/kate.do")
	public String kate(Model model) {
		
		
		List<Kategorie> list =service.getKateList();
		model.addAttribute("list", list);
		return "/notices/kate";
	}
	
//	@RequestMapping("/add.do")
//	public String add(Board brd) {
//		
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		
//		
//		brd.setTitle(title);
//		brd.setContent(content);
//		brd.setKateNo(katNo);
//		brd.setUserId((String)request.getSession().getAttribute("userId"));
//		
//		return "redirect:/admin/list.do";
//	}
	
	@RequestMapping("/katadd.do")
	public String kateadd(@RequestParam("kateName") String kateName, @RequestParam("kateDetail") String kateDetail) {
				
		Kategorie kat = new Kategorie();
		kat.setKateName(kateName);
		kat.setKateDetail(kateDetail);
		
		service.savekat(kat);
		
		return "redirect:/admin/kate.do";
	}
	
//	@RequestMapping("/view.do")
//	public String admin_view(@RequestParam("brdNo")String no, Model model) {
//		
//		String no = request.getParameter("brdNo");
//		Board vo = service.getBoardView(Integer.parseInt(no));
//		request.setAttribute("info", vo);
//		service.CntUpdate(vo.getBrdNo());
//		vo.setCnt(vo.getCnt()+1);
//		List<Comment> comlist= adminService.getCommentList(Integer.parseInt(no));
//		request.setAttribute("list", comlist);
//		
//		return "/notices/admin_view";
//	}
	
	
	
	@RequestMapping("/remove2.do")
	public String remove2(@RequestParam("id")String str) {
		
		service.removeUser(str);
				
		return "redirect:/admin/memberlist.do";
	}
	
	@RequestMapping("/remove3.do")
	public String remove3(@RequestParam("kateSearchNo")String str) {
		
		service.removeKategorie(Integer.parseInt(str));
		
		return "redirect:/admin/kate.do";
	}
	
	@PostMapping("/katmod.do")
	@ResponseBody
	public Kategorie katmod(@RequestParam("katNo") int kateNo) {		//ajax 활용
		
//		PrintWriter out = response.getWriter();
		
		//추천 표시
		Kategorie kat = service.getKateView(kateNo); // 추천 여부 확인
		
//		// Gson 객체 생성
//        Gson gson = new Gson();
// 
//        // Student 객체 -> Json 문자열
//        String studentJson = gson.toJson(kat);
// 
//        //ajax로 전달
//		out.print(studentJson);
		

		return kat;
//		return "/admin/kate.do";
	}
	
	@RequestMapping("/katsave.do")
	public String katsave(@RequestParam("kateName")String kateName, @RequestParam("kateDetail")String kateDetail, @RequestParam("katSearchId")String kateSearchId, Kategorie kat, Model model) {
		
		kat.setKateName(kateName);
		kat.setKateDetail(kateDetail);
		kat.setKateNo(Integer.parseInt(kateSearchId));

		service.savekat(kat);
		
		return "redirect:/admin/kate.do";
	}
	
	@RequestMapping("/addReply.do")
	public void addReply() {
		return;
	}*/

}
