/**
 * 
 */
package security.core.properties;

/**
 * @author Hu
 *
 */
public class SessionProperties {
	
	/**
	 * maximumsession for one user, default = 1
	 */
	private int maximumSessions = 1;
	/**
	 * false
	 */
	private boolean maxSessionsPreventsLogin;
	/**
	 * jump to new session
	 */
	private String sessionInvalidUrl = SecurityConstants.DEFAULT_SESSION_INVALID_URL;

	public int getMaximumSessions() {
		return maximumSessions;
	}

	public void setMaximumSessions(int maximumSessions) {
		this.maximumSessions = maximumSessions;
	}

	public boolean isMaxSessionsPreventsLogin() {
		return maxSessionsPreventsLogin;
	}

	public void setMaxSessionsPreventsLogin(boolean maxSessionsPreventsLogin) {
		this.maxSessionsPreventsLogin = maxSessionsPreventsLogin;
	}

	public String getSessionInvalidUrl() {
		return sessionInvalidUrl;
	}

	public void setSessionInvalidUrl(String sessionInvalidUrl) {
		this.sessionInvalidUrl = sessionInvalidUrl;
	}
	
}
