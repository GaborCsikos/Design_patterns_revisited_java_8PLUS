package week2.structural.proxy.dynamic;

import java.lang.reflect.Proxy;

public class DynamicProxy {

    @SuppressWarnings("unchecked")
    public static <T> T addHandler(T target, Class<T> itf) {
        return (T) Proxy.newProxyInstance(
                itf.getClassLoader(),
                new Class<?>[]{itf},
                new HealthCheckHandler(target));
    }

}
