/**
 * 
 */
package security.core.social.qq.connet;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

import security.core.social.qq.api.facebook;
import security.core.social.qq.api.FBImpl;

/**
 * @author Hu
 *
 */
public class FBServiceProvider extends AbstractOAuth2ServiceProvider<facebook> {

	private String appId;
	
	private static final String URL_AUTHORIZE = "https://graph.facebook.com/oauth2.0/authorize";
	
	private static final String URL_ACCESS_TOKEN = "https://graph.facebook.com/oauth2.0/token";
	
	public FBServiceProvider(String appId, String appSecret) {
		super(new FBOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
		this.appId = appId;
	}
	
	@Override
	public FB getApi(String accessToken) {
		return new FBImpl(accessToken, appId);
	}

}
