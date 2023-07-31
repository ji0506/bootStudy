package com.cafe.study.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe.study.model.Board;
import com.cafe.study.model.Kategorie;
import com.cafe.study.model.Seat;
import com.cafe.study.repository.SeatRepository;
import com.cafe.study.service.BoardService;
import com.cafe.study.service.KateService;
import com.cafe.study.service.SeatService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/main/*")
@AllArgsConstructor
public class MainController {

	@Autowired
	private BoardService brdService;
	
	@Autowired
	private SeatService seatService;

	@Autowired
	private KateService katService;	

	

	@RequestMapping("/main.do")
	public String main(Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {

		List<Kategorie> katlist  = katService.getMenu("02");
		request.setAttribute("katlist", katlist);

		
		List<Seat> list = seatService.getSeatList();
		model.addAttribute("list", list);

		List<Board> viewlist = brdService.getBoardViewList();
		model.addAttribute("viewlist", viewlist);

		Map<String, Integer> statis = seatService.getSeatCount();
		model.addAttribute("statis", statis);

		
		/*
		String action = request.getPathInfo();

		try {
			if (action == null) {

				List<Seat> list = seatservice.getSeatList(); // �¼� ���� �������� seatDao�ε��� select all
				model.addAttribute("list", list); // VIEW�� �¼� ���� ����
				List<Board> viewlist = boardservice.getBoardViewList(); // �ֽű� �������� boarddao selsect Main viewlist
				model.addAttribute("viewlist", viewlist); // �ֽű� ����
				Map<String, Integer> statis = seatservice.getSeatCount();//seatDao slelctSeatcoun
				model.addAttribute("statis", statis);

				return "/main/main";

			} else if ("/main.do".equals(action)) {
				List<Seat> list = seatservice.getSeatList();// �¼� ���� ��������
				model.addAttribute("list", list);// VIEW�� �¼� ���� ����

				List<Board> viewlist = boardservice.getBoardViewList(); // �ֽű� ��������
				model.addAttribute("viewlist", viewlist); // �ֽű� ����
				Map<String, Integer> statis = seatservice.getSeatCount(); // �¼� ī��Ʈ ��������
				model.addAttribute("statis", statis); // �¼� ����Ʈ ����
				return "/main/main";
				
			} else if (action.equals("/change.do")) {

				PrintWriter out = response.getWriter();

				// �¼� ���� ����
				Seat seat = new Seat();
				//�̰� vo����Ŷ� �Ű杢�ʿ䰡����
				String userId = request.getParameter("userId");
				//���ʵ� ���� �պ����ҵ� getparameter���ʿ������������
				seat.setUserId(userId);
				seat.setSeatNo(request.getParameter("SeatNo"));
				seat.setSeatComment("02");

				// ����
				seatservice.SeatUpdate(seat);//seatDAo update
				
				out.print("success");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		model.addAttribute("userId","admin");
		
		return "main/main";
	}
	@RequestMapping("/change.do")
	@ResponseBody
	public String change(@RequestParam("userId") String userID, @RequestParam("seatNo") String seatNo){

		Seat seat = new Seat();

//		seat.setUserId(userId);
//		seat.setSeatNo(seatNo);

		//저장
//		seatService.SeatUpdate(seat);

		return "success";
	}


}
