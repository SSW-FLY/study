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
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private StudentDao studentDao;

    @Override
    public Student findOne() {
        return studentDao.findOne();
    }

    public List<Student> findList() {
        return studentDao.findList();
    }
}
