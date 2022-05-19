import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Greetings {
    HashMap<String[], String[]> knowledge ;

    public Greetings()
    {
        knowledge = new HashMap<String[], String[]>();
        knowledge.put(new String[] {"Hi", "Hello"}, new String[] {"Hello","Hi there!","Hello! nice to meet you!", "Hello... Pleased to meet you!", "Hello, How can I help you?"});
        knowledge.put(new String[] {"Good morning"}, new String[] {"Good morning", "Hi! Good morning", "Good morning. How can I help you?"});
        knowledge.put(new String[] {"Good afternoon"}, new String[] {"Good afternoon", "Hi! Good afternoon", "Good afternoon. How can I help you?"});
        knowledge.put(new String[] {"Good evening"}, new String[] {"Good evening", "Hi! Good evening", "Good evening. How can I help you?"});
        knowledge.put(new String[] {"Good night"}, new String[] {"Good night", "Good night. Sweet dreams!"});
        knowledge.put(new String[] {"Good bye", "Bye"}, new String[] {"Good bye", "Good bye. Take care", "Good bye. Have a nice day"});
        knowledge.put(new String[] {"Thank you", "Thanks"}, new String[] {"You're welcome!", "My pleasure", "Thank you. Have a nice day!"});
    }

    public String getReply(String userInput){
        Set<String[]> keys = knowledge.keySet();
        for (String[] key : keys) {
            String lowercaseKey = String.join("", key).toLowerCase().replaceAll("\\s", "");
            String lowercaseInput = userInput.toLowerCase();

            if(lowercaseKey.contains((lowercaseInput))){
                String[] replies = knowledge.get(key);
                Random random = new Random();
                int  n  =  random.nextInt(replies.length);
                return replies[n];
            }
        }
        return "Oops.. say something else";
    }
}
