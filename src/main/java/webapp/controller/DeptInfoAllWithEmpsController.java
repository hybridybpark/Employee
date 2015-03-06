package webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import webapp.model.Dept;
import webapp.service.DeptInfoService;

/**
 * Servlet implementation class DeptController
 */
@WebServlet("/dept/infoallemps")
public class DeptInfoAllWithEmpsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Log log = LogFactory.getLog(DeptInfoAllWithEmpsController.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptInfoAllWithEmpsController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    ApplicationContext factory = null;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	factory = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		log.info("dept called");
		
		PrintWriter out = response.getWriter();
		
		out.print("<h1>dept called<h1>");
		
		log.info("factory = " + factory);
		
		DeptInfoService service = factory.getBean(DeptInfoService.class);
		
		List<Dept> list = service.getDeptInfoAllWithEmps();
		
		request.setAttribute("deptList", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/dept/infoAllWithEmps.jsp");
		
		rd.forward(request, response);
		
	}

}
