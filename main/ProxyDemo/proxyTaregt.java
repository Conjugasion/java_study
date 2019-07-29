package ProxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther Lucas
 * @date 2019/1/25 10:37
 * 在运行时代理
 */
public class proxyTaregt {
    public static void main(String[] args) {
        targetInterface objProxy = (targetInterface)Proxy.newProxyInstance(target.class.getClassLoader(), new Class[]{targetInterface.class}, new InvocationHandler() {
            //invoke  代表执行代理对象的方法
            @Override
            // Method 代表目标对象的方法字节码对象
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("目标方法前的逻辑");
                // 执行目标对象的方法
                Object o = method.invoke(new target(), null);
                System.out.println("目标方法后的逻辑");
                return o;
            }
        });
        String s = objProxy.method2();
        System.out.println(s);
    }
}
