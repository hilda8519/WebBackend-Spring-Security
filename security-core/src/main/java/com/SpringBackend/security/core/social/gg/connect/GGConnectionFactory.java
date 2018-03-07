/**
 * 
 */
package security.core.social.Google.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.support.OAuth2Connection;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2ServiceProvider;

import security.core.social.Google.api.Google;

/**
 * 
 * 
 * @author Hu
 *
 */
public class GGConnectionFactory extends OAuth2ConnectionFactory<Google> {
	
	/**
	 * @param appId
	 * @param appSecret
	 */
	public GGConnectionFactory(String providerId, String appId, String appSecret) {
		super(providerId, new GGServiceProvider(appId, appSecret), new GGAdapter());
	}
	
	
	@Override
	protected String extractProviderUserId(AccessGrant accessGrant) {
		if(accessGrant instanceof GGAccessGrant) {
			return ((GGAccessGrant)accessGrant).getOpenId();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.social.connect.support.OAuth2ConnectionFactory#createConnection(org.springframework.social.oauth2.AccessGrant)
	 */
	public Connection<Google> createConnection(AccessGrant accessGrant) {
		return new OAuth2Connection<google>(getProviderId(), extractProviderUserId(accessGrant), accessGrant.getAccessToken(),
				accessGrant.getRefreshToken(), accessGrant.getExpireTime(), getOAuth2ServiceProvider(), getApiAdapter(extractProviderUserId(accessGrant)));
	}

	/* (non-Javadoc)
	 * @see org.springframework.social.connect.support.OAuth2ConnectionFactory#createConnection(org.springframework.social.connect.ConnectionData)
	 */
	public Connection<Google> createConnection(ConnectionData data) {
		return new OAuth2Connection<Google>(data, getOAuth2ServiceProvider(), getApiAdapter(data.getProviderUserId()));
	}
	
	private ApiAdapter<Google> getApiAdapter(String providerUserId) {
		return new GoogleAdapter(providerUserId);
	}
	
	private OAuth2ServiceProvider<Google> getOAuth2ServiceProvider() {
		return (OAuth2ServiceProvider<Google>) getServiceProvider();
	}

	
}
