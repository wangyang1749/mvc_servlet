package com.mvc.servlet1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/us.do")
public class UserServlet extends BaseServlet {
	/**
	 * ��ͬ���캯��һ����Ĭ�ϻ���service������
	 * ��дserviceҲ�ᣬ�Զ����ø���service
	 * @throws IOException 
	 */
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.service(req, resp);
//	}
	User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String list(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		user.setAge(10);
		user.setUserName("���");
		req.setAttribute("user",user);
		return "list.jsp";
	}
	public void load(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		resp.getWriter().write("����ҳ��");
	}
	
}
