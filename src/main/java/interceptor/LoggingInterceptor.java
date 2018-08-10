package interceptor;

import annotation.Loggable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Interceptor
@Loggable
public class LoggingInterceptor {
	
	@Inject
	private Logger logger;
	
	@AroundInvoke
	public Object logMethod(InvocationContext invocationContext) throws Exception {
		logger.entering(invocationContext.getTarget().getClass().getName(), invocationContext.getMethod().getName());
		System.out.println("ENTERING: " + invocationContext.getTarget().getClass().getName() + ": " +
				invocationContext.getMethod().getName());
		try {
			return invocationContext.proceed();
		} finally {
			logger.exiting(invocationContext.getTarget().getClass().getName(), invocationContext.getMethod().getName());
			System.out.println("EXITING: " + invocationContext.getTarget().getClass().getName() + ": " +
					invocationContext.getMethod().getName());
		}
	}
}