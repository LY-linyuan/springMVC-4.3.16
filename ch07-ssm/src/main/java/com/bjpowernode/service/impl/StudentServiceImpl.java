package com.bjpowernode.service.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-08-03 11:44
 */
@Service
public class StudentServiceImpl implements StudentService {

    // 引用类型的自动注入 @Autowired, @Resource
    @Resource
    private StudentDao studentDao;


    @Override
    public int addStudent(Student student) {
        int nums = studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> findStudents() {
        return studentDao.selectStudents();
    }
}
