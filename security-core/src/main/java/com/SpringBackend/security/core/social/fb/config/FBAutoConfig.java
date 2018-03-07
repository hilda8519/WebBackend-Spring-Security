/**
 * 
 */
package security.core.social.fb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

import security.core.properties.QQProperties;
import security.core.properties.SecurityProperties;
import security.core.social.qq.connet.QQConnectionFactory;

/**
 * @author Hu
 *
 */
@Configuration
@ConditionalOnProperty(prefix = "security.social.fb", name = "app-id")
public class FBAutoConfig extends SocialAutoConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter
	 * #createConnectionFactory()
	 */
	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		FBProperties fbConfig = securityProperties.getSocial().getQq();
		return new FBConnectionFactory(fbConfig.getProviderId(), fbConfig.getAppId(), fbConfig.getAppSecret());
	}

}
