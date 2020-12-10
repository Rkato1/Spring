package kr.or.iei.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.iei.person.model.vo.Person;
import kr.or.iei.person.model.vo.PersonMgr;

/**
 * Servlet implementation class Dependency2Servlet
 */
public class Dependency2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dependency2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Person 객체 생성 2명
		//1 빈 객체 생성 후 setter를 이용한 방식
		//2 생성자를 이용한 방식
//		Person p1 = new Person();
//		p1.setName("이름1");
//		p1.setAge(11);
//		p1.setAddr("주소1");
//		
//		Person p2 = new Person("이름2",22,"주소2");
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("personContext.xml");
		PersonMgr pm = (PersonMgr)cntx.getBean("pm");
		//Person p1 = (Person) cntx.getBean("p1");
		Person p1 = pm.getP();
		System.out.println(p1.getName());
		System.out.println(p1.getAge());
		System.out.println(p1.getAddr());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
