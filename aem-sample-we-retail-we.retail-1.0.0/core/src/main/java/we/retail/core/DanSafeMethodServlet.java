package we.retail.core;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by admin on 4/5/2017.
 */

@SlingServlet(paths = "/bin/dhanesh/repo", methods = "GET")
public class DanSafeMethodServlet extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = -3960692666512058118L;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)throws ServletException, IOException {
        response.setHeader("Content-Type", "application/json");
        response.getWriter().print("{\"coming\" : \"soon\"}");
    }
}
