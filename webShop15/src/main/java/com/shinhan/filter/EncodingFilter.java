package com.shinhan.filter;

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
@WebFilter("*.do")
public class EncodingFilter extends HttpFilter implements Filter {
    
	
	public EncodingFilter() {
		System.out.println("EncodingFilter 생성됨");
	}
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("======요청 전에 수행========");
		long startTime = System.nanoTime();
		String path = ((HttpServletRequest)request).getContextPath();
		String uri = ((HttpServletRequest)request).getRequestURI();
		String realpath = request.getRealPath(".");
		
		System.out.println("path:"+path);
		System.out.println("uri:"+uri);
		System.out.println("realpath:"+realpath);
		
		// place your code here
		request.setCharacterEncoding("utf-8");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		System.out.println("======해당 응답 전에 수행========");
		long endTime = System.nanoTime();
		
		System.out.println("해당 업무 수행에 소요된 시간:"+(endTime-startTime)+"ns");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
