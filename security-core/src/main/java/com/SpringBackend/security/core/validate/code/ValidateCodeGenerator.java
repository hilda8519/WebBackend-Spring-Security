/**
 * 
 */
package security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Hu
 *
 */
public interface ValidateCodeGenerator {

	ValidateCode generate(ServletWebRequest request);
	
}
