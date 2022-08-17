package com.example.spock.controller;

import com.example.spock.dao.StudentDao;
import com.example.spock.domain.Student;
import com.example.spock.service.TestService;
import com.example.spock.service.impl.TestServiceImpl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import javax.annotation.Resource;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imp
 * @date 2022/2/28
 */
@RestController
public class TestController {

    @Resource
    private StudentDao studentDao;

    @GetMapping("/api/test")
    public void test() {
        String beanName = this.studentDao.getBeanName();
        System.out.println(beanName);
    }

    public static void main(String[] args) {
//        TestService proxy = getProxy(new TestServiceImpl());
//        Student one = proxy.findOne();
//        System.out.println(one);
        TestServiceImpl cglib = cglib(new TestServiceImpl());
        Student one1 = cglib.findOne();
        System.out.println(one1);
        String ok = cglib.findOk();
        System.out.println(ok);
        String aFinal = cglib.findFinal();
        System.out.println(aFinal);
    }

    /**
     * 类加载器的作用: 1. 通过类加载器吧对应的类字节码文件加载到JVM中 2. 通过类加载器创建类的Class对象进而创建这个类的对象如何获得类加载器：虚拟机为每一个类的.class文件自动分配与之对应的ClassLoader,
     * 动态代理类没有源文件，它是通过动态字节码技术生成，把字节码直接写入jvm. 此时在动态代创建的过程中，需要ClassLoader创建代理类的Class对象，可是因为动态代理类没有.classs文件， JVM也就不会为他分配ClassLoader,但是又需要，就只能借用一个。
     * 所以找一个我们自己写的类获取Class对象在调用getClassLoader()即可， 这里注意不要使用JDK的类获取，因为不是一个类加载器。
     *
     * @param testService
     * @return
     */
    public static TestService getProxy(TestServiceImpl testService) {
        return (TestService) Proxy.newProxyInstance(testService.getClass().getClassLoader(),
                testService.getClass().getInterfaces(), (o, method, objects) -> {
                    System.out.println("method is start -----------");
                    Object invoke = method.invoke(testService, objects);
                    System.out.println("method is end -------------");
                    return invoke;
                });
    }

    public static TestServiceImpl cglib(TestServiceImpl testService) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(testService.getClass().getClassLoader());
        enhancer.setSuperclass(TestServiceImpl.class);
        MethodInterceptor methodInterceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib method begin -------");
                Object one = method.invoke(testService, objects);
                System.out.println("cglib method end ---------");
                return one;
            }
        };
        enhancer.setCallback(methodInterceptor);
        Object o = enhancer.create();
        return (TestServiceImpl) o;
    }

}

