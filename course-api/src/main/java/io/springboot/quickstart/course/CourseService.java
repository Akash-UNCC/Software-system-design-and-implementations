package io.springboot.quickstart.course;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import io.springboot.quickstart.topic.TopicService;

@Service
public class CourseService {

	
	TopicService topicService = new TopicService() ;
	
	
	private List<Course> courses = new ArrayList<Course>();
	
	
	
		Course course1 = new Course("spring course", "Spring Framework course", "Spring Framework Description course", topicService.getAllTopics().get(0));
		Course course2 = new Course("java course", "Core Java course", "Core Java Description course",topicService.getAllTopics().get(0));
		Course course3 = new Course("javascript course", "JavaScript course", "JavaScript Description course",topicService.getAllTopics().get(2));

		{
			courses.add(course1);courses.add(course2);courses.add(course3);
		}
		
	public List<Course> getAllCourses(String id) {
		List<Course> allcourses = new ArrayList<Course>();
		for (int t = 0; t < courses.size(); t++) {
			if (courses.get(t).getTopic().getId().equals(id)) {
				allcourses.add(courses.get(t));		
			}
		}
		  return allcourses;
	}

	public Course getCourse(String id) {
		
		for (int t = 0; t < courses.size(); t++) {
			if (courses.get(t).getId().equals(id)) {
				return courses.get(t);		
			}
		}
		return null;
	}

	//
	public void addCourse(Course course) {
		courses.add(course);

	}

	public void updateCourse(Course course, String id) {
		for (int t = 0; t < courses.size(); t++) {
			if (courses.get(t).getId().equals(id)) {
				courses.set(t, course);
				return;
			}
		}
	}

	public void deleteTopic(Course course, String id) {
		courses.removeIf(t->t.getId().equals(id));
		}

}
