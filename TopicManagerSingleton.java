package test;

import java.util.Collection;
import java.util.Map;

public class TopicManagerSingleton
{
    public static class TopicManager {
        Map<String, Topic> topics;
        private static final TopicManager instance = new TopicManager();

        private TopicManager(){
            topics = new HashMap<>();
        }

        public Topic getTopic(String topicName){
            //Checking if it exists and if it will not be produced
            if(!topics.containsKey(topicName))
            {
                topics.put(topicName, new Topic(topicName));
            }
            return topics.get(topicName);
        }

        public Collection<Topic> getTopics(){
            return topics.values();
        }

        public void clear(){
            topics.clear();
        }

    }

    public static TopicManager getInstance() {
        return TopicManager.instance;
     }
    
}
