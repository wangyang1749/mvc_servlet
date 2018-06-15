package com.mvc.servlet1;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ʹ��Baseservlet����mvc������
 * ����UserServlet����ʱ���ȷ��ʵ���service������
 * UserServlet�̳�BaseServlet֮�������Զ�����service���������ҵ������ĸ��෽��
 */
public class BaseServlet extends HttpServlet {
	@Override
	@SuppressWarnings("rawtypes")
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		try {
			Method[] ms = this.getClass().getDeclaredMethods();
			for (Method m : ms) {
				String name = m.getName();
				if(name.startsWith("set")) {
					name = name.substring(3);
					
					Class c = Class.forName("com.mvc.servlet1."+name);
					Object o= c.newInstance();
					m.invoke(this, o);
				}
			}
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		
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
