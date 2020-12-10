package kr.or.iei.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.model.vo.BeanFactory;
import kr.or.iei.model.vo.LgTV;
import kr.or.iei.model.vo.TV;

/**
 * Servlet implementation class DependencyServlet
 */
public class DependencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DependencyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//결합도를 낮추는 과정(모듈화)
//		SamsungTV tv = new SamsungTV();
//		LgTV tv = new LgTV();
		//다형성을 높이는 과정
//		TV tv = new LgTV();
		String beanName = request.getParameter("beanName");
		TV tv = (TV)BeanFactory.getBean(beanName);
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
