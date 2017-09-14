package runtimeprocessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TestingInvocationHandler implements InvocationHandler {
	private Object proxied;

	public TestingInvocationHandler(Object proxied) {
		this.proxied = proxied;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Method m = proxied.getClass().getMethod(method.getName(),
				method.getParameterTypes());
		if (m.isAnnotationPresent(Testing.class)) {
			System.out.println("\tIn the annotation processor");
		}
		return method.invoke(proxied, args);
	}
}