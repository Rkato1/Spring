package kh.mvc.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.사용자의 요청 path를 추출
		String path = request.getRequestURI();
		System.out.println("path : "+path);
		//2.HandlerMapping을 통해서 path해당하는 컨트롤러 객체를 검색
		HandlerMapping mappings = new HandlerMapping();
		Controller ctrl = mappings.getController(path);
		//3.검색된 컨트롤러를 실행
		String viewName = ctrl.handelRequest(request, response);
		//4.ViewResolver를 통해 viewName의 경로를 선택
		ViewResolver resolver = new ViewResolver("/view/", ".jsp");
		String view = resolver.getView(viewName);
		//5.선택된 화면으로 이동
		response.sendRedirect(view);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
