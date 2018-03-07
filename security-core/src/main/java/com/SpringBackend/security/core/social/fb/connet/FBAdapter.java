/**
 * 
 */
package security.core.social.facebook.connet;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import security.core.social.qq.api.facebook;
import security.core.social.qq.api.facebookUserInfo;

/**
 * @author Hu
 *
 */
public class FBAdapter implements ApiAdapter<facebook> {

	@Override
	public boolean test(FACEBOOK api) {
		return true;
	}

	@Override
	public void setConnectionValues(FACEBOOK api, ConnectionValues values) {
		FACEBOOKUserInfo userInfo = api.getUserInfo();
		
		values.setDisplayName(userInfo.getNickname());
		values.setImageUrl(userInfo.getFigureurl_qq_1());
		values.setProfileUrl(null);
		values.setProviderUserId(userInfo.getOpenId());
	}

	@Override
	public UserProfile fetchUserProfile(FACEBOOK api) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatus(FACEBOOK api, String message) {
		//do noting
	}

}
