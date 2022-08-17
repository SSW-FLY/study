package com.example.spock.service.impl;

import com.example.spock.dao.StudentDao;
import com.example.spock.domain.Student;
import com.example.spock.service.TestService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author imp
 * @date 2022/2/28
 */
public class TestServiceImpl implements TestService {

    @Override
    public Student findOne() {
        System.out.println("find one");
        return new Student();
    }

    //
//    public List<Student> findList() {
//        return null;
//    }
//
//
    public String findOk() {
        return "ok";
    }

    public final String findFinal() {
        return "final";
    }
}
