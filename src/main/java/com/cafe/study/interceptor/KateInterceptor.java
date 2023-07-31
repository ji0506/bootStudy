package com.cafe.study.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerInterceptor;
import com.cafe.study.model.Kategorie;
import com.cafe.study.service.KateService;

public class KateInterceptor implements HandlerInterceptor {

	@Autowired
	private KateService katService;	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		try {
			
			List<Kategorie> katlist  = katService.getMenu("02");
			request.setAttribute("katlist", katlist);
			request.setAttribute("katlist", katlist);
			String strKatNo = request.getParameter("katNo");
			int katNo = strKatNo != null ? Integer.parseInt(strKatNo): 1;
			if(strKatNo != null) {
				katNo = Integer.parseInt(strKatNo);
				request.setAttribute("katTargetNo", katNo);
			}
			else {
				katNo = 0;
				request.setAttribute("katTargetNo", 0);				
			}

			for(Kategorie kat : katlist)
				if(katNo == kat.getKateNo())
					request.setAttribute("katTargetName", kat.getKateName());
			
			//String userId = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			request.setAttribute("userId", "admin");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
