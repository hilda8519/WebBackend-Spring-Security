/**
 * 
 */
package security.core.validate.code.sms;

/**
 * @author Hu
 *
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

	/* (non-Javadoc)
	 * @see security.core.validate.code.sms.SmsCodeSender#send(java.lang.String, java.lang.String)
	 */
	@Override
	public void send(String mobile, String code) {
		System.out.println("send to "+mobile+"crc"+code);
	}

}
