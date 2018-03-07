/**
 * 
 */
package security.core.validate.code.sms;

/**
 * @author Hu
 *
 */
public interface SmsCodeSender {
	
	void send(String mobile, String code);

}
