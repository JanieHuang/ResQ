package ca.ljz.resq.web.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.ljz.resq.domain.AppUser;
import ca.ljz.resq.service.BusinessService;
import ca.ljz.resq.service.impl.BusinessServiceImpl;
import ca.ljz.resq.utils.WebUtils;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/reg")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			AppUser user = WebUtils.request2Bean(request, AppUser.class);
			user.setId(UUID.randomUUID().toString());
			
			BusinessService service = new BusinessServiceImpl();
			service.addUser(user);

			request.setAttribute("message", "Registered");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "Failed");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
