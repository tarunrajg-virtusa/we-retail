package we.retail.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Dictionary;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.osgi.service.component.ComponentContext;

@Component(immediate = true, metatype = true, label = "QR Servlet", description = "Sample Restful Servlet")
@Service
@Properties({
        @Property(name = "sling.servlet.paths", value = { "/bin/destinations" }, label = "Servlet Path"),
        @Property(name = "sling.servlet.methods", value = "GET", label = "Request Method") })

public class RestfulServlet extends SlingSafeMethodsServlet {

    @Reference
    private RestfulService service;

    @Override
    protected void doGet(SlingHttpServletRequest request,
                         SlingHttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String category = request.getParameter("category");

        String jsonData = "{\"error\":\"no data\"}";
        if(category.equals("all")){
            jsonData = service.getAllDestinations();
        } else if(category.equals("tables")){
            jsonData = service.getAsia();
        } else if(category.equals("accessories")){
            jsonData = service.getMiddleEast();
        }
        PrintWriter writer = response.getWriter();
        writer.println(jsonData);
        writer.flush();
    }

    @Activate
    protected void activate(ComponentContext context) {
        final Dictionary<?, ?> properties = context.getProperties();
    }

}

