package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.regDao;

import vo.regVo;

/**
 * Servlet implementation class RegController
 */
@WebServlet("/RegController")
public class RegController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		try {
			String f = (String) request.getParameter("flag");
//			System.out.println(f);
//			String f = request.getServletPath();
			if (f != null) {
				if (f.equals("insert")) {
					String s1 = (String) request.getParameter("fn");
					String s2 = (String) request.getParameter("ln");
					regVo v0 = new regVo(s1, s2);
					regDao r1 = new regDao();
					r1.insert(v0);
					response.sendRedirect("registration.jsp");
				}
			}
			if (f.equals("showdata")) {
				regDao r1 = new regDao();
				List<regVo> list2 = new ArrayList<regVo>();
				list2 = r1.showdata();
				
				session.setAttribute("list", list2);
				
				response.sendRedirect("viewdata.jsp");
			}
			
			if(f.equals("search")){
				
				String s1 = request.getParameter("search");
			
				regDao r1 = new regDao();
				List<regVo> ls = new ArrayList<regVo>();
				ls= r1.search(s1);
				
				session.setAttribute("list1",ls);
				
				response.sendRedirect("searchdata.jsp");
				
			}
			if(f.equals("delete")){
				regDao r1 = new regDao();
				regVo v0 = new regVo();
				int id=Integer.parseInt(request.getParameter("id"));
				v0.setId(id);
				r1.delete(v0);
				response.sendRedirect("RegController?flag=showdata");
			}
			
			if(f.equals("update")){
				
				regVo v0 = new regVo();
				int id=Integer.parseInt(request.getParameter("id"));
				session.setAttribute("id", id);
				response.sendRedirect("editdata.jsp");
				
			}
			
			if(f.equals("edit")){
				String s1= (String)request.getParameter("fn");
				String s2= (String)request.getParameter("ln");
				regDao r1 = new regDao();
				int id = (Integer)session.getAttribute("id");
				regVo v0 = new regVo(id,s1,s2);
				
				r1.update(v0);
				response.sendRedirect("RegController?flag=showdata");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
