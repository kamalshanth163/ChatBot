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
                        "<li onclick=\"selectOption('pt1')\">Wild life</li>" +
                        "<li onclick=\"selectOption('pt2')\">Culture</li>" +
                        "<li onclick=\"selectOption('pt3')\">Adventure</li>" +
                        "</ul>"
                });

        knowledge.put(
                new String[] {"pt1"},
                new String[] {
                    "<p>Wild life packages for you</p>" +
                        "<ul id='packages'>" +
                        "<li onclick=\"selectOption('p1')\">" +
                            "<div>\n" +
                            "   <h3>Wild life tour in kandy</h3>\n" +
                            "   <h4>LKR 1200.00</h4>\n" +
                            "</div>" +
                        "</li>" +
                        "<li onclick=\"selectOption('p2')\">" +
                            "<div>\n" +
                            "   <h3>Safari tour in colombo</h3>\n" +
                            "   <h4>LKR 2200.00</h4>\n" +
                            "</div>" +
                        "</li>" +
                        "</ul>"
                });
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
//
//    public String[] getPackages(){
//        var packages =
//    }
}
