package apps.we_retail.components.content.button;
import com.adobe.cq.sightly.WCMUse;
import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.resource.ValueMap;
import java.util.*;
import org.apache.sling.commons.json.JSONArray;
import org.apache.sling.commons.json.JSONObject;
import org.apache.sling.commons.json.JSONException;
import javax.jcr.*;
import com.day.cq.commons.jcr.*;

public class Button extends WCMUsePojo {

    private ValueMap properties;
    private Page page;
    private PageManager pageManager;
    private String path;
    private String locale = "en-us";
    String pageName;

    HashMap<String,String> promoMap = new HashMap<String,String>();

    @Override
    public void activate() throws Exception {
        this.properties = getProperties();
        page = super.getCurrentPage();
        pageManager = super.getPageManager();
        path = page.getPath().toLowerCase();
        pageName = page.getName().toLowerCase();


    }

    public String getDestination() {
        String s =
    }

    public String getBackgroundColor() {



        return properties.get("backgroundColor", String.class);


    }
    public String getLinkTo() {
        return properties.get("http://www.google.com", String.class);
    }
    public String getLabel() {
        return properties.get("label", String.class);
    }

}

