/**
 * 
 */
package security.core.social.FACEBOOK.connet;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import security.core.social.FACEBOOK.api.FACEBOOK;

/**
 * @author Hu
 *
 */
public class FBConnectionFactory extends OAuth2ConnectionFactory<FACEBOOK> {

	public FBConnectionFactory(String providerId, String appId, String appSecret) {
		super(providerId, new FACEBOOKServiceProvider(appId, appSecret), new FBAdapter());
	}

}
