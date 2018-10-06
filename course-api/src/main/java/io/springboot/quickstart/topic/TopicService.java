package io.springboot.quickstart.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<Topic>();
	
		static Topic topic1 = new Topic("spring", "Spring Framework", "Spring Framework Description");
		static Topic topic2 = new Topic("java", "Core Java", "Core Java Description");
		static Topic topic3 = new Topic("javascript", "JavaScript", "JavaScript Description");
		
		
		{
			topics.add(topic1);topics.add(topic2);topics.add(topic3);
		}
		

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);

	}

	public void updateTopic(Topic topic, String id) {
		for (int t = 0; t < topics.size(); t++) {
			if (topics.get(t).getId().equals(id)) {
				topics.set(t, topic);
				return;
			}
		}
	}

	public void deleteTopic(Topic topic, String id) {
            topics.removeIf(t->t.getId().equals(id));
		}
		
	

}
