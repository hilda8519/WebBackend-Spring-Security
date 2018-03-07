/**
 * 
 */
package security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 
 * 
 * @author zhailiang
 *
 */
public interface ValidateCodeProcessor {

	/**
	 * 
	 */
	String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

	/**
	 * 
	 * 
	 * @param request
	 * @throws Exception
	 */
	void create(ServletWebRequest request) throws Exception;

	/**
	 * 
	 * 
	 * @param servletWebRequest
	 * @throws Exception
	 */
	void validate(ServletWebRequest servletWebRequest);

}
