/**
 * 
 */
package security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author Hu
 *
 */
public class FBProperties extends SocialProperties {
	
	private String providerId = "FACEBOOK";

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	
}
