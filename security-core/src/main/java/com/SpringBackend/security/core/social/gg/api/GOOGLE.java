/**
 * 
 */
package security.core.social.GOOGLE.api;

/**
 * 
 * 
 * @author Hu
 *
 */
public interface GOOGLE {

	/* (non-Javadoc)
	 * @see com.ymt.pz365.framework.security.social.api.SocialUserProfileService#getUserProfile(java.lang.String)
	 */
	WeixinUserInfo getUserInfo(String openId);
	
}
