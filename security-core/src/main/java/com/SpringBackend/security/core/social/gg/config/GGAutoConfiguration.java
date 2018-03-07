/**
 * 
 */
package security.core.social.google.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;

import security.core.properties.SecurityProperties;
import security.core.properties.WeixinProperties;
import security.core.social.ImoocConnectView;
import security.core.social.weixin.connect.WeixinConnectionFactory;

/**
 * 
 * 
 * @author Hu

 *
 */
@Configuration
@ConditionalOnProperty(prefix = "security.social.google", name = "app-id")
public class GGAutoConfiguration extends SocialAutoConfigurerAdapter {

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
		GGProperties weixinConfig = securityProperties.getSocial().getWeixin();
		return new GGConnectionFactory(weixinConfig.getProviderId(), GGConfig.getAppId(),
				GGConfig.getAppSecret());
	}
	
	@Bean({"connect/GGConnect", "connect/GGConnected"})
	@ConditionalOnMissingBean(name = "GGConnectedView")
	public View GGConnectedView() {
		return new ConnectView();
	}
	
}
