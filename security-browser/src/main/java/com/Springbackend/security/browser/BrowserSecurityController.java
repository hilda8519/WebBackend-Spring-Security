/**
 * 
 */
package security.browser;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import security.browser.support.SimpleResponse;
import security.browser.support.SocialUserInfo;
import security.core.properties.SecurityConstants;
import security.core.properties.SecurityProperties;

/**
 * @author Hu
 *
 */
@RestController
public class BrowserSecurityController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private RequestCache requestCache = new HttpSessionRequestCache();

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Autowired
	private SecurityProperties securityProperties;

	@Autowired
	private ProviderSignInUtils providerSignInUtils;

	

	@RequestMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
	@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
	public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		SavedRequest savedRequest = requestCache.getRequest(request, response);

		if (savedRequest != null) {
			String targetUrl = savedRequest.getRedirectUrl();
			logger.info("getRequest:" + targetUrl);
			if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
				redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
			}
		}

		return new SimpleResponse("go to loggin page");
	}

	@GetMapping("/social/user")
	public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
		SocialUserInfo userInfo = new SocialUserInfo();
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
		userInfo.setProviderId(connection.getKey().getProviderId());
		userInfo.setProviderUserId(connection.getKey().getProviderUserId());
		userInfo.setNickname(connection.getDisplayName());
		userInfo.setHeadimg(connection.getImageUrl());
		return userInfo;
	}

}
