package com.springmvc;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.view.InternalResourceView;

import com.springmvc.model.Login;
import com.springmvc.utils.Security;

public class JstlView extends InternalResourceView {
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Determine which request handle to expose to the RequestDispatcher.
		HttpServletRequest requestToExpose = getRequestToExpose(request);

		// Expose the model object as request attributes.
		exposeModelAsRequestAttributes(model, requestToExpose);

		// Expose helpers as request attributes, if any.
		exposeHelpers(requestToExpose);

		// Determine the path for the request dispatcher.
		String dispatcherPath = prepareForRendering(requestToExpose, response);
		
		if(dispatcherPath.contains("login.jsp")) {
			// force everything to be template.jsp
			RequestDispatcher rd = requestToExpose.getRequestDispatcher(dispatcherPath);
			rd.include(requestToExpose, response);
		} 
		else { 
			if(request.getSession().getAttribute("userSession") == null) {
				request.setAttribute("login", new Login());
				response.sendRedirect(request.getContextPath()+"/main/login/login.do");
			}
		
			// set original view being asked for as a request parameter
			requestToExpose.setAttribute("partial", dispatcherPath.substring(dispatcherPath.lastIndexOf("pages/") + 6));

			// force everything to be template.jsp
			RequestDispatcher rd = requestToExpose.getRequestDispatcher("/WEB-INF/pages/template.jsp");
			rd.include(requestToExpose, response);
		}
	}
}