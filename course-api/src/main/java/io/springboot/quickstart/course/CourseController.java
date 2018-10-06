package io.springboot.quickstart.course;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.springboot.quickstart.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService CourseService;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return CourseService.getAllCourses(id);	
	}
	
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getTopic(@PathVariable String id) {
		return CourseService.getCourse(id);	
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value ="/topics/{topicId}/course")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		CourseService.addCourse(course);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value ="/topics/{topicId}/courses/{id}")
	public void updateTopic(@RequestBody Course course,@PathVariable String topicId,@PathVariable String id) {
		CourseService.updateCourse(course, id);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value ="/topics/{topicId}/courses/{id}")
	public void deleteTopic(@RequestBody Course course,@PathVariable String topicId,@PathVariable String id) {
		CourseService.deleteTopic(course, id);
	}
	
	
	
	
}
