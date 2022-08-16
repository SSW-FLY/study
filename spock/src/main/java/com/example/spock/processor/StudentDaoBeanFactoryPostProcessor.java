package com.example.spock.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author imp
 * @date 2022/8/14
 */
@Component
public class StudentDaoBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        BeanDefinition studentDao = beanFactory.getBeanDefinition("studentDao");
        studentDao.setDestroyMethodName("test");
        MutablePropertyValues values = studentDao.getPropertyValues();
        values.add("beanName", "studentDaoA");
    }
}
