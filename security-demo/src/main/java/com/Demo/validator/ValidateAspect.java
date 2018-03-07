/**
 * 
 */
package Demo.validator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.validation.BindingResult;

/**
 * @author zhailiang
 *
 */
//@Aspect
//@Component
public class ValidateAspect {
	
	@Around("execution(* Demo.web.controller.UserController.*(..))")
	public Object handleValidateResult(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("get into joinpoint");
		
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			if(arg instanceof BindingResult) {
				BindingResult errors = (BindingResult)arg;
				if (errors.hasErrors()) {
					throw new ValidateException(errors.getAllErrors());
				}
			}
		}
		
		Object result = pjp.proceed();
		
		return result;
	}

}
