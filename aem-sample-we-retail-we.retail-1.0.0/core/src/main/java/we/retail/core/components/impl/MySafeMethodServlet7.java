package we.retail.core.components.impl;
import java.io.IOException;

import javax.servlet.ServletException;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

@SlingServlet(paths = "/bin/company/repo7", methods = "GET")
public class MySafeMethodServlet7 extends SlingSafeMethodsServlet {
	private static final long serialVersionUID = -3960692666512058118L;
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)throws ServletException, IOException {
		response.setHeader("Content-Type", "application/json");
		response.getWriter().print("{\"Releasing\" : \"soon\"}");
	}
}