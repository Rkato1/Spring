package kr.or.iei.person.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import kr.or.iei.person.model.vo.Person;

/**
 * Servlet implementation class Dependency3Servlet
 */
public class Dependency3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dependency3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("personContext.xml");
		Person p1 = (Person)cntx.getBean("p1");
		Person p2 = (Person)cntx.getBean("p2");
		System.out.println("첫번째 : "+p1.getAge());
		p1.setAge(p1.getAge()+1);
		System.out.println("두번째 : "+p1.getAge());
		Person p3 = (Person)cntx.getBean("p1");
		System.out.println("세번째 : "+p3.getAge());
		//객체를 만들어두고 요청할때마다 해당 객체를 재사용하는 방식
		//singleton방식(static)
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

