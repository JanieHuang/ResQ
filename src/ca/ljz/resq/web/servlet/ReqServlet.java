package ca.ljz.resq.web.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.ljz.resq.domain.AppUser;
import ca.ljz.resq.domain.Post;
import ca.ljz.resq.service.BusinessService;
import ca.ljz.resq.service.impl.BusinessServiceImpl;
import ca.ljz.resq.utils.WebUtils;

/**
 * Servlet implementation class ReqServlet
 */
@WebServlet("/req")
public class ReqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReqServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BusinessService service = new BusinessServiceImpl();

		request.getSession().setAttribute("post", service.findAllPosts());

		response.sendRedirect(request.getContextPath() + "/requests.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Post user = WebUtils.request2Bean(request, Post.class);
			user.setId(UUID.randomUUID().toString());
			user.setAppUser((AppUser) request.getSession().getAttribute("user"));

			BusinessService service = new BusinessServiceImpl();
			service.addPost(user);

		} catch (Exception e) {
			request.setAttribute("message", "Failed to post");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		response.sendRedirect(request.getContextPath() + "/req");
	}

}
