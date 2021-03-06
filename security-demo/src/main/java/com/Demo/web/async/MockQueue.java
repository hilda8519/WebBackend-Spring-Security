/**
 * 
 */
package Demo.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Hu
 *
 */
@Component
public class MockQueue {

	private String placeOrder;

	private String completeOrder;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	public String getPlaceOrder() {
		return placeOrder;
	}

	public void setPlaceOrder(String placeOrder) throws Exception {
		new Thread(() -> {
			logger.info("get order request, " + placeOrder);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.completeOrder = placeOrder;
			logger.info("placed an order," + placeOrder);
		}).start();
	}

	public String getCompleteOrder() {
		return completeOrder;
	}

	public void setCompleteOrder(String completeOrder) {
		this.completeOrder = completeOrder;
	}

}
