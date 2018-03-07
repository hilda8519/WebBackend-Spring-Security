/**
 * 
 */
package Demo.service.impl;

import org.springframework.stereotype.Service;

import Demo.service.HelloService;

/**
 * @author Hu
 *
 */
@Service
public class HelloServiceImpl implements HelloService {

	/* (non-Javadoc)
	 * @see Demo.service.HelloService#greeting(java.lang.String)
	 */
	@Override
	public String greeting(String name) {
		System.out.println("greeting");
		return "hello "+name;
	}

}
