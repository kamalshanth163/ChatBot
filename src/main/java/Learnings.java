import java.util.HashMap;
import java.util.Random;
import java.util.Set;

class Learnings {
    static HashMap<String, String> learnings = new HashMap<String, String>();

    static String getReply(String userInput){
        if(learnings.get(userInput) != null){
            return learnings.get(userInput);
        }
        else {
            return "";
        }
    }

    static String trainMe(String question, String answer){
        learnings.put(question, answer);
        return "Thanks a lot for teaching me :)";
    }
}
