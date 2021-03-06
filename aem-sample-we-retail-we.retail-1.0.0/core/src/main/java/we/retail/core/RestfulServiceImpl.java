package we.retail.core;

        import com.day.cq.commons.jcr.JcrUtil;
        import com.day.cq.commons.jcr.JcrConstants;
        import java.io.InputStream;
        import java.io.StringWriter;
        import java.lang.StringBuilder;
        import java.nio.charset.Charset;
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Dictionary;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import java.util.Set;
        import java.util.TreeSet;

        import javax.jcr.Node;
        import javax.jcr.RepositoryException;
        import javax.jcr.Session;
        import javax.jcr.query.*;

//        import org.apache.commons.io.IOUtils;
        import org.apache.felix.scr.annotations.Activate;
        import org.apache.felix.scr.annotations.Component;
        import org.apache.felix.scr.annotations.Property;
        import org.apache.felix.scr.annotations.Reference;
        import org.apache.felix.scr.annotations.Service;
        import org.apache.jackrabbit.commons.JcrUtils;
        import org.apache.sling.api.resource.ResourceResolver;
        import org.apache.sling.api.resource.ResourceResolverFactory;
        import org.apache.sling.commons.json.JSONException;
        import org.apache.sling.commons.osgi.PropertiesUtil;
        import org.apache.sling.jcr.api.SlingRepository;
        import org.osgi.service.component.ComponentContext;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;


@Component(immediate = true, metatype = true, label = "Product Catalog Service")
@Service(RestfulService.class)

public class RestfulServiceImpl implements RestfulService {

    private static Logger LOGGER = LoggerFactory
            .getLogger(RestfulServiceImpl.class);

    private ResourceResolver resourceResolver;

    @Reference
    private SlingRepository repository;

    @Reference
    private ResourceResolverFactory resolverFactory;


    private Session getSession() throws RepositoryException {
        return repository.loginAdministrative(null);
    }

    public String getAllDestinations() {

        String json = "{\"destinations\":\"none\"}";
        Session session = null;
        String path = "content/data/qr/jcr:content/catalog";
        try{
            session = getSession();
            Node rootNode = session.getRootNode();
            Node sourceNode = rootNode.getNode(path);
            if(sourceNode.hasProperty("allProducts")) {
                json = sourceNode.getProperty("allProducts").getString();
            }
        } catch (Exception e) {
            LOGGER.error("Data source " + path + "could not be read.", e);
        } finally {
            if (session != null && session.isLive()) {
                session.logout();
            }
        }
        return json;
    }


    public String getAsia() {

        String json = "{\"products\":\"none\"}";
        Session session = null;
        String path = "content/data/qr/jcr:content/catalog";
        try{
            session = getSession();
            Node rootNode = session.getRootNode();
            Node sourceNode = rootNode.getNode(path);
            if(sourceNode.hasProperty("tables")) {
                json = sourceNode.getProperty("tables").getString();
            }
        } catch (Exception e) {
            LOGGER.error("Data source " + path + "could not be read.", e);
        } finally {
            if (session != null && session.isLive()) {
                session.logout();
            }
        }
        return json;
    }

    public String getMiddleEast() {

        String json = "{\"destinations\":\"none\"}";
        Session session = null;
        String path = "content/qr/data/jcr:content/catalog";
        try{
            session = getSession();
            Node rootNode = session.getRootNode();
            Node sourceNode = rootNode.getNode(path);
            if(sourceNode.hasProperty("accessories")) {
                json = sourceNode.getProperty("accessories").getString();
            }
        } catch (Exception e) {
            LOGGER.error("Data source " + path + "could not be read.", e);
        } finally {
            if (session != null && session.isLive()) {
                session.logout();
            }
        }
        return json;
    }
}
