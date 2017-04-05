import com.adobe.cq.sightly.WCMUse;
import org.apache.sling.api.resource.ValueMap;

public class Video extends WCMUsePojo {

	private ValueMap properties;

	@Override
	public void activate() throws Exception {
		this.properties = getProperties();
	}

	public String getBackgroundColor() {
		return properties.get("backgroundColor", String.class);
	}
	public String getContentAlignClass() {
		return properties.get("contentAlignClass", String.class);
	}
	public String getColorTheme() {
		return properties.get("colorTheme", String.class);
	}
	public String getMediaPosition() {
		return properties.get("mediaPosition", "media--left");
	}
	public String getCaretOption() {
		return properties.get("caretOption", String.class);
	}
	public String getBackgroundImage() {
		return properties.get("backgroundImage", String.class);
	}
	public String getBrandingImage() {
		return properties.get("brandingImage", String.class);
	}
	public String getBrandingImageAlt() {
		return properties.get("brandingImageAlt", String.class);
	}
	public String getHeadline() {
		return properties.get("headline", "-- Media Video Component Here --");
	}
	public String getBody() {
		return properties.get("body", String.class);
	}
	public String getButtonTextOne() {
		return properties.get("buttonTextOne", String.class);
	}
	public String getButtonTextTwo() {
		return properties.get("buttonTextTwo", String.class);
	}
	public String getLink1Url() {
		return properties.get("link1Url", String.class);
	}
	public String getLink1Target() {
		return properties.get("link1Target", String.class);
	}
	public String getButtonClass1() {
		return properties.get("buttonClass1", String.class);
	}
	public String getLink2Url() {
		return properties.get("link2Url", String.class);
	}
	public String getLink2Target() {
		return properties.get("link2Target", String.class);
	}
	public String getButtonClass2() {
		return properties.get("buttonClass2", String.class);
	}
	public String getVideoID() {
		return properties.get("videoID", String.class);
	}
	public String getVideoTitle() {
		return properties.get("videoTitle", String.class);
	}
}
