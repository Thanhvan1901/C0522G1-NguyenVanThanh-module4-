package vn.codegym.service;

import org.springframework.stereotype.Service;
import vn.codegym.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    void save(Student student);
}
