package com.generation.service;

import com.generation.model.Course;
import com.generation.model.EnrolledCourse;
import com.generation.model.Student;

import java.util.HashMap;
import java.util.Scanner;

public class StudentService
{
    private final HashMap<String, Student> students = new HashMap<>();

    public void registerStudent( Student student )
    {
        //TODO Add new student to the students hashmap
        if(!students.containsKey(student.getId())){
            students.put(student.getId(), student);
        }

    }

    public Student findStudent( String studentId )
    {
        //TODO Find the student from the Hashmap with the student id
        if(students.containsKey(studentId)){
            return students.get(studentId);
        }

        return null;
    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO check if students hashmap contains the studentsId, if not enroll student to the course

        if(students.containsKey(studentId)){
            Student student = students.get(studentId);
            EnrolledCourse eCourse = new EnrolledCourse(course);
            student.enrollToCourse(eCourse);

        }


    }

    public void showSummary() {
        //TODO Loop through students hashmap and print out students' details including the enrolled courses
        for (Student s : students.values()) {
            System.out.println(s);
            System.out.println("Enrolled Courses");
            HashMap<String, EnrolledCourse> enrolledCourseList = s.getEnrolledCourses();

            for (EnrolledCourse e : enrolledCourseList.values()) {
                System.out.println(e);
            }
        }
    }
    public HashMap<String, EnrolledCourse> enrolledCourses(Student student)
    {
        //TODO return a HashMap of all the enrolledCourses

        return student.getEnrolledCourses();
    }

    public Course findEnrolledCourse( Student student, String courseId )
    {
        //TODO return the course enrolled by the student from the course Id
        if(student.getEnrolledCourses().containsKey(courseId)){
            return student.getEnrolledCourses().get(courseId);
        }

        return null;
    }

    public void gradeStudent(Student student, Course course, double grade) {
        student.gradeCourse(course.getCode(), grade);
    }



    public HashMap<String, EnrolledCourse> getPassedCourses(Student student) {
        return student.findPassedCourses();
    }
}
