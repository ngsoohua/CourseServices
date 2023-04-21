package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Student extends Person
{
    public static final double PASS_MIN_GRADE = 3.0;

    private final HashMap<String, EnrolledCourse> enrolledCourses = new HashMap<>();


    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public boolean enrollToCourse( Course course )
    {
        //TODO Check if student has already enrolled to the course, if not add the course to enrolledCourses hashmap
        if(!enrolledCourses.containsKey(course.getCode())){
            EnrolledCourse studentCourse = new EnrolledCourse(course);
            enrolledCourses.put(course.getCode(),studentCourse);
            return true;
        }
        return false;
    }

    public HashMap<String, EnrolledCourse> getEnrolledCourses()
    {
        //TODO return a Hashmap of all the enrolledCourses
        return enrolledCourses;
    }

    public void gradeCourse( String courseCode, double grade )
    {
        //TODO set the grade for the enrolled Course
        if(enrolledCourses.containsKey(courseCode)){
            EnrolledCourse eCourse = enrolledCourses.get(courseCode);
            eCourse.setGrade(grade);
        }

    }

    public Course findCourseById( String courseId )
    {
        //TODO return a Course from the course Id

        if(enrolledCourses.containsKey(courseId)){
            EnrolledCourse eCourse = enrolledCourses.get(courseId);
            return eCourse;
        }

        return null;
    }

    public HashMap<String, EnrolledCourse> findPassedCourses()
    {
        //TODO Check the enrolled courses grade and compare to the passing grade

        HashMap<String,EnrolledCourse>passedCourseList = new HashMap<>();

        for(EnrolledCourse e : enrolledCourses.values()){

            if(e.getGrade() >= 3.0 ){
                passedCourseList.put(e.getCode(),e);

            }
        }
        return passedCourseList;
    }

    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
