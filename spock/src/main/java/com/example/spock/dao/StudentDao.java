package com.example.spock.dao;

import com.example.spock.domain.Student;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author imp
 * @date 2022/2/28
 */
@Component
@Data
public class StudentDao implements InitializingBean {

    private String beanName;

    public Student findOne() {
        return Student.builder().id(1L).name("test").build();
    }

    public List<Student> findList() {
        List<Student> students = new ArrayList<>();
        Student test = Student.builder().id(1L).name("test1").build();
        Student test2 = Student.builder().id(2L).name("test2").build();
        students.add(test);
        students.add(test2);
        return students;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init");
    }
}
