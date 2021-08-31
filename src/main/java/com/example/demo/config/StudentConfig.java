package com.example.demo.config;

import com.example.demo.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Description Configuration of Student class
 */
@Configuration
public class StudentConfig {
    @Bean(name = "student")//@Bean here should be used with @Configuration
    public Student getStudent() {
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(25);
        student.setGender("male");
        return student;
    }

    @Bean(name = "student_prototype")//@Bean here should be used with @Configuration
    @Scope(value = "prototype")
    public Student getStudent_prototype() {
        Student student = new Student();
        student.setName("lisi");
        student.setAge(22);
        student.setGender("male");
        return student;
    }
}
