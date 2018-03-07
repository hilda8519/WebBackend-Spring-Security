/**
 * 
 */
package security.core.social.weixin.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import security.core.social.google.api.google;
import security.core.social.google.api.googleUserInfo;

/**
 * 
 * 
 * @author Hu
 *
 */
public class GGAdapter implements ApiAdapter<Google> {
	
	private String openId;
	
	public GGAdapter() {}
	
	public GGAdapter(String openId){
		this.openId = openId;
	}

	/**
	 * @param api
	 * @return
	 */
	@Override
	public boolean test(Google api) {
		return true;
	}

	/**
	 * @param api
	 * @param values
	 */
	@Override
	public void setConnectionValues(Google api, ConnectionValues values) {
		GoogleUserInfo profile = api.getUserInfo(openId);
		values.setProviderUserId(profile.getOpenid());
		values.setDisplayName(profile.getNickname());
		values.setImageUrl(profile.getHeadimgurl());
	}

	/**
	 * @param api
	 * @return
	 */
	@Override
	public UserProfile fetchUserProfile(Google api) {
		return null;
	}

	/**
	 * @param api
	 * @param message
	 */
	@Override
	public void updateStatus(Google api, String message) {
		//do nothing
	}

}
