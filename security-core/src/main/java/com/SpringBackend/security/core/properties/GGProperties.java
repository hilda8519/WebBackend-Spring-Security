/**
 * 
 */
package security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author Hu
 *
 */
public class GGProperties extends SocialProperties {
	
	
	private String providerId = "google";

	/**
	 * @return the providerId
	 */
	public String getProviderId() {
		return providerId;
	}

	/**
	 * @param providerId the providerId to set
	 */
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	

}
