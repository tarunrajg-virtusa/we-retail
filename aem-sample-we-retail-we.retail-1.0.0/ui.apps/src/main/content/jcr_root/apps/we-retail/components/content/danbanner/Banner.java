package apps.we_retail.components.content.danbanner;

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

public class Banner extends WCMUsePojo {

	private ValueMap properties;
	private Page page;
	private PageManager pageManager;
	private String path;
	private String locale = "en-us";
	String pageName;

	HashMap<String, String> promoMap = new HashMap<String, String>();

	@Override
	public void activate() throws Exception {
		this.properties = getProperties();
		page = super.getCurrentPage();
		pageManager = super.getPageManager();
		path = page.getPath().toLowerCase();
		pageName = page.getName().toLowerCase();
	}

	public String getLocale() {

	}

	public String getHeadline() {
		return properties.get("headline", String.class);
	}

	public String getBody() {
		return properties.get("body", String.class);
	}

	public String getLinkLabel() {
		return properties.get("linkLabel", String.class);
	}

	public String getOpenNewTab() {
		return properties.get("openNewTab", String.class);
	}

	public String getImageUrl() {
		return properties.get("imageUrl", String.class);
	}

	public String getLinkTo() {
		return properties.get("linkTo", String.class);
	}

}
