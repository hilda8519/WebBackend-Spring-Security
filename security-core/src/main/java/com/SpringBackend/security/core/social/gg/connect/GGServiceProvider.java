/**
 * 
 */
package security.core.social.Google.connect;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

import security.core.social.Google.api.Google;
import security.core.social.Google.api.GoogleImpl;

/**
 * 
 * 
 * @author Hu
 *
 */
public class GoogleServiceProvider extends AbstractOAuth2ServiceProvider<Google> {
	
	/**
	 
	 */
	private static final String URL_AUTHORIZE = "https://open.google.com/connect/qrconnect";
	/**
	 * 
	 */
	private static final String URL_ACCESS_TOKEN = "https://api.google.com/sns/oauth2/access_token";

	/**
	 * @param appId
	 * @param appSecret
	 */
	public GoogleServiceProvider(String appId, String appSecret) {
		super(new GoogleOAuth2Template(appId, appSecret,URL_AUTHORIZE,URL_ACCESS_TOKEN));
	}


	/* (non-Javadoc)
	 * @see org.springframework.social.oauth2.AbstractOAuth2ServiceProvider#getApi(java.lang.String)
	 */
	@Override
	public Google getApi(String accessToken) {
		return new GoogleImpl(accessToken);
	}

}
