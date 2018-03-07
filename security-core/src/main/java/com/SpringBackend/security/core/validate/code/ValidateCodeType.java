/**
 * 
 */
package security.core.validate.code;

import security.core.properties.SecurityConstants;

/**
 * @author Hu
 *
 */
public enum ValidateCodeType {
	
	/**
	 * sms crc
	 */
	SMS {
		@Override
		public String getParamNameOnValidate() {
			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
		}
	},
	/**
	 * pic crc
	 */
	IMAGE {
		@Override
		public String getParamNameOnValidate() {
			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
		}
	};

	/**
	 * 
	 * @return
	 */
	public abstract String getParamNameOnValidate();

}
