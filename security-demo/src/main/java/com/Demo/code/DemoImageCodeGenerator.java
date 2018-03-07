/**
 * 
 */
package Demo.code;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import security.core.validate.code.ValidateCodeGenerator;
import security.core.validate.code.image.ImageCode;

/**
 * @author Hu
 *
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {

	/* (non-Javadoc)
	 * @see security.core.validate.code.ValidateCodeGenerator#generate(org.springframework.web.context.request.ServletWebRequest)
	 */
	@Override
	public ImageCode generate(ServletWebRequest request) {
		System.out.println("Advanced pic crc");
		return null;
	}

}
