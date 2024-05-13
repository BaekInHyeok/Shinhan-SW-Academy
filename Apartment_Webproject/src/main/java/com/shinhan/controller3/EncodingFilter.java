package com.shinhan.controller3;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Filter : 요청Filter, 응답Filter
 * 공통적으로 여러 서블릿에 적용하기 위한 코드들을 작성
 */
@WebFilter("/*")
public class EncodingFilter extends HttpFilter implements Filter {
    
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// place your code here
		request.setCharacterEncoding("utf-8");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
