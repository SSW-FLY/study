package com.example.spock

import com.example.spock.dao.StudentDao
import com.example.spock.domain.Student
import com.example.spock.service.impl.TestServiceImpl
import spock.lang.Specification

/**
 * @author imp
 * @date 2022/2/28
 */
class TestServiceImplTest extends Specification {

    def studentDao = Mock(StudentDao)
    def studentService = new TestServiceImpl(studentDao: studentDao)

    def "test getStudentById"() {
        given: "mock student"
        def student1 = new Student(id: 1, name: "yc1")
        def student2 = new Student(id: 2, name: "yc2")

        and: "mock studentDao"
        studentDao.findOne() >> student1
        studentDao.findList() >> [student1, student2]

        when: "获取学生信息"
        def response = studentService.findOne();
        def test1 = studentService.findList();

        then: "结果验证"
        with(response) {
            id == 1
            name == "yc1"
        }
        with(test1) {
            test1.size() == 2
            test1.get(0).id == 1
            test1.get(0).name == "yc1"
            test1.get(1).id == 2
            test1.get(1).name == "yc2"
        }

    }


}
