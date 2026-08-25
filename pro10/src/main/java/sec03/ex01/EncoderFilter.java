package sec03.ex01;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class EncoderFilter extends HttpFilter implements Filter {
	ServletContext servletContext;
	// init: 
	@Override
    public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 방식으로 인코딩 시작...");
		servletContext = getServletContext();
	}  
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter 메소드 호출되어 실행 중");
		
		// 요청 필터 시작: 서블릿 실행 전 공통 작업
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String contextPath = ((HttpServletRequest)request).getContextPath();
		String pathInfo = ((HttpServletRequest)request).getRequestURI();
		String realPath = request.getRealPath(pathInfo);
		
		String mesg = "ContextPath: " + contextPath
					+ "\nURI 정보: " + pathInfo
					+ "\n물리적 URI 정보: " + realPath;
		
		System.out.println(mesg);
		
		long begin = System.currentTimeMillis();
		
		for(int i = 0; i < 1000; i++) {
			System.out.println(i);
		}
		
		// ====== ▲ 요청 시 실행 ▲ ======
		// =================================================================================
		// ====== ▼ 응답 시 실행 ▼ ======
		chain.doFilter(request, response);
		
		
		// 서블릿의 코드가 모두 실행 후 응답 시 실행
		long end = System.currentTimeMillis();
		
		System.out.println("작업 수행시간: " + (end - begin) + "ms");
		
	}
	@Override
	public void destroy() {
		
	}
}
