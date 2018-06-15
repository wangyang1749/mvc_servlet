package com.mvc.servlet1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用Baseservlet处理mvc的请求
 * 由于UserServlet调用时首先访问的是service方法，
 * UserServlet继承BaseServlet之后，它会自动调用service方法，并且调用它的父类方法
 */
public class BaseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String method =  req.getParameter("method");
		try {
			Method m =  this.getClass().getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			String path =(String) m.invoke(this, req,resp);
			req.getRequestDispatcher("WEB-INF/"+path).forward(req, resp);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
