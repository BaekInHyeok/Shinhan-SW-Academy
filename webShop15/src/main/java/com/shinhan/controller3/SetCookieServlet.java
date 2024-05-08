package com.shinhan.controller3;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Base64.Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieServlet
 */
@WebServlet("/jsp/cookieSet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	//-----여러 페이지로 이동 시 특정 정보를 유지하기 위함-----
	//쿠키를 만들어서 응답문에 실어서 보냄
	//브라우저에 저장됨. 재요청시 request에 담아서 간다
	//쿠키를 확인할 수 있다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		Cookie c1 = new Cookie("myid",id);
		Cookie c2 = new Cookie("mypw",pw);
		Cookie c3 = new Cookie("myinfo",URLEncoder.encode("신한금융아카데미", "utf-8"));
		c1.setMaxAge(24*60*60);//하루동안 유효
		c2.setMaxAge(60);//1분 유효
		//c3은 유효시간을 설정하지 않음 >> 브라우저가 살아있는 동안 유효함
		response.addCookie(c1);
		response.addCookie(c2);
		response.addCookie(c3);
	
		request.getRequestDispatcher("cookie.jsp").forward(request, response);
		
	}

}
