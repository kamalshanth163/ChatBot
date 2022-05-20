import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Questions {
    HashMap<String[], String[]> knowledge ;

    public Questions()
    {
        knowledge = new HashMap<String[], String[]>();
        knowledge.put(
                new String[] {"What packages", "What are the packages", "Package", "Packages", "Package details"},
                new String[] {
                    "<p>Pick one package type</p>" +
                        "<ul id='packageTypes'>" +
                        "<li onclick=\"selectOption('Wild life')\">Wild life</li>" +
                        "<li onclick=\"selectOption('Culture')\">Culture</li>" +
                        "<li onclick=\"selectOption('Adventure')\">Adventure</li>" +
                        "</ul>"
                });

        // package types
        knowledge.put(
                new String[] {"Wild life", "Wild life tour"},
                new String[] {
                    "<p>Wild life tour packages for you</p>" +
                        "<ul id='packages'>" +
                        "<li>" +
                            "<div>\n" +
                            "   <h3>Wild life tour in Kandy</h3>\n" +
                            "   <h4>LKR 1200.00</h4>\n" +
                            "</div>" +
                        "</li>" +
                        "<li>" +
                            "<div>\n" +
                            "   <h3>Safari tour in Colombo</h3>\n" +
                            "   <h4>LKR 2200.00</h4>\n" +
                            "</div>" +
                        "</li>" +
                        "</ul>" +
                    "<a href='https://www.google.com' target='_blank'>learn more</a>"
                });

        knowledge.put(
                new String[] {"Culture", "Culture tour"},
                new String[] {
                    "<p>Culture tour packages for you</p>" +
                        "<ul id='packages'>" +
                        "<li>" +
                        "<div>\n" +
                        "   <h3>Culture tour in Galle</h3>\n" +
                        "   <h4>LKR 1200.00</h4>\n" +
                        "</div>" +
                        "</li>" +
                        "<li>" +
                        "<div>\n" +
                        "   <h3>Culture tour in Jaffna</h3>\n" +
                        "   <h4>LKR 2200.00</h4>\n" +
                        "</div>" +
                        "</li>" +
                        "</ul>" +
                        "<a href='https://www.google.com' target='_blank'>learn more</a>"
                });

        knowledge.put(
                new String[] {"Adventure", "Adventure tour"},
                new String[] {
                    "<p>Adventure tour packages for you</p>" +
                        "<ul id='packages'>" +
                        "<li>" +
                        "<div>\n" +
                        "   <h3>Adventure tour in Trincomalee</h3>\n" +
                        "   <h4>LKR 1200.00</h4>\n" +
                        "</div>" +
                        "</li>" +
                        "<li>" +
                        "<div>\n" +
                        "   <h3>Adventure tour in Nuwara eliya</h3>\n" +
                        "   <h4>LKR 2200.00</h4>\n" +
                        "</div>" +
                        "</li>" +
                        "</ul>" +
                        "<a href='https://www.google.com' target='_blank'>learn more</a>"
                });

        knowledge.put(
                new String[] {"Train me"},
                new String[] {
                        "<div>\n" +
                        "   <p>What would be your expected reply for.. </p>\n" +
                        "</div>"
                });

        knowledge.put(
                new String[] {"Stop training"},
                new String[] {
                        "<div>\n" +
                        "   <p>Training has stopped.. Say or ask something else..</p>\n" +
                        "</div>"
                });
    }

    public String getReply(String userInput){
        Set<String[]> keys = knowledge.keySet();
        for (String[] key : keys) {
            String lowercaseKey = String.join("", key).toLowerCase().replaceAll("\\s", "");
            String lowercaseInput = userInput.toLowerCase();

            if(lowercaseKey.contains(lowercaseInput)){
                String[] replies = knowledge.get(key);
                Random random = new Random();
                int  n  =  random.nextInt(replies.length);
                return replies[n];
            }
        }
        return "Oops.. say something else";
    }
}
