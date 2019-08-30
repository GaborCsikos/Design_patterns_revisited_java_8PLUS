package week2.structural.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HealthCheckHandler implements InvocationHandler {
    private static boolean healthy = false;
    private final Object target;

    HealthCheckHandler(Object target) {
        this.target = target;
    }

    public static boolean isHealthy() {
        return healthy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();

        if (name.equals("doHealthCheck")) {
            healthy = true;
        }


        return method.invoke(target, args);
    }

}