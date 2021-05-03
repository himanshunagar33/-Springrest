package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;
@Service
public class CourseServiceIMP implements CourseService {
	List<Course> list;
	
	public CourseServiceIMP() {
		list= new ArrayList<>();
		list.add(new Course(145, "Java 8 Course", "This course includes all the changes from "));
		list.add(new Course(124, "Scala", "This Course is for the basic of Scala"));
		list.add(new Course(129, "Selenium", "This Course is for the UI Testing"));
		list.add(new Course(101, "RestAssured", "This course is for the API Testing"));
	}
	@Override
	public List<Course> getCourses() {

		return list;
	}
	@Override
	public Course getCourse(long courseId) {
		
		Course c= null;
		for(Course course: list) {
			if(course.getId()==courseId) {
				c=course;
			}
		}
		return c;
	}
	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}
	@Override
	public Course removeCourse(long courseId) {
		Course cd= null;
		Iterator itr= list.iterator();
		while(itr.hasNext()) {
		Course temp= (Course) itr.next();
		if(temp.getId()==courseId) {
			cd=temp;
			itr.remove();
			}
		}
		
		return cd;
	}
	@Override
	public Course putCourse(Course course) {
		Course cp=null;
		int index=-1;
	for(int i=0;i<list.size();i++) {
		cp=list.get(i);
		if(cp.getId()==course.getId()) {
			index=i;
		}
	}
		
		if(index>-1) {
			list.set(index, course);
		}
		else
		list.add(course);
		
		return course;
	}
	

}
