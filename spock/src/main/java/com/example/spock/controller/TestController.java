package com.example.spock.controller;

import com.example.spock.dao.StudentDao;
import com.example.spock.domain.Student;
import com.example.spock.service.TestService;
import com.example.spock.service.impl.TestServiceImpl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import javax.annotation.Resource;
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
        TestService proxy = getProxy(new TestServiceImpl());
        Student one = proxy.findOne();
        System.out.println(one);
    }

    public static TestService getProxy(TestServiceImpl testService) {
        return (TestService) Proxy.newProxyInstance(testService.getClass().getClassLoader(),
                testService.getClass().getInterfaces(), (o, method, objects) -> {
                    System.out.println("method is start -----------");
                    Object invoke = method.invoke(testService, objects);
                    System.out.println("method is end -------------");
                    return invoke;
                });
    }
}
