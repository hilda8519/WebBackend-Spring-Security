/**
 * 
 */
package security.core.social.google.connect;

import org.springframework.social.oauth2.AccessGrant;

/**
 * 
 * 
 * @author Hu
 *
 */
public class GGAccessGrant extends AccessGrant {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7243374526633186782L;
	
	private String openId;
	
	public GGAccessGrant() {
		super("");
	}

	public GGAccessGrant(String accessToken, String scope, String refreshToken, Long expiresIn) {
		super(accessToken, scope, refreshToken, expiresIn);
	}

	/**
	 * @return the openId
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * @param openId the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
}
