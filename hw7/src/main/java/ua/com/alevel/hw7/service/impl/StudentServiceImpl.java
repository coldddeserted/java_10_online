package ua.com.alevel.hw7.service.impl;

import ua.com.alevel.hw7.db.DBResourse;
import ua.com.alevel.hw7.entity.Student;
import ua.com.alevel.hw7.service.StudentService;

import java.util.Collection;

public class StudentServiceImpl implements StudentService {
    DBResourse dbResourse = DBResourse.getInstance();
    @Override
    public void create(Student entity) {
        dbResourse.createStudent(entity);
    }

    @Override
    public void update(Student entity) {
        dbResourse.updateStudent(entity);
    }

    @Override
    public void delete(String id) {
        dbResourse.deleteStudent(id);
    }

    @Override
    public Student findById(String id) {
        return dbResourse.findStudentById(id);
    }

    @Override
    public Collection<Student> findAll() {
        return dbResourse.findAllStudent();
    }
}
