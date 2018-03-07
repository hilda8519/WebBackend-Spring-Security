/**
 * 
 */
package security.core.properties;

/**
 * @author Hu
 *
 */
public class SocialProperties {
	
	private String filterProcessesUrl = "/auth";

	private FBProperties fb = new FBProperties();
	
    private GGProperties gg = new GGProperties();
	public FBProperties getFB() {
		return fb;
	}

	public void setFB(FBProperties fb) {
		this.fb = fb;
	}

	public String getFilterProcessesUrl() {
		return filterProcessesUrl;
	}

	public void setFilterProcessesUrl(String filterProcessesUrl) {
		this.filterProcessesUrl = filterProcessesUrl;
	}

	public GGProperties getGG() {
		return gg;
	}

	public void setGG(GGProperties gg) {
		this.gg = gg;
	}
	
}
