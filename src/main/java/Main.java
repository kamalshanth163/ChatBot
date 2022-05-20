import spark.ModelAndView;
import spark.Spark;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Started the application");

        Spark.get("/", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            return new ThymeleafTemplateEngine().render(new ModelAndView(model, "index"));
        });

        Spark.get("/chat", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            return new ThymeleafTemplateEngine().render(new ModelAndView(model, "chat-window"));
        });

        Spark.post("/chat", (request, response) -> {

            var userInput = request.queryParams("userInput").toLowerCase().replaceAll("\\s", "");
            var expectedReply = request.queryParams("expectedReply");

            Inputs inputs = new Inputs();

            String greetings = inputs.removeSpaces(inputs.greetings);
            String questions = inputs.removeSpaces(inputs.questions);

            var defaultResponse = "Ooops.. To better understand how this all works, I recommend you to <a href='https://www.google.com' target='_blank'>learn more</a>.<hr />" +
                    "<button id='trainMeBtn' onclick=\"startTraining()\">Train me</button>";

            if(userInput.length() == 0) return "Say or ask something..";

            if(expectedReply == ""){
                if(greetings.contains(userInput)){
                    Greetings model = new Greetings();
                    return model.getReply(userInput);
                }
                else if(questions.contains(userInput)){
                    Questions model = new Questions();
                    return model.getReply(userInput);
                }
                else {
                    String reply = Learnings.getReply(userInput);
                    if(reply == ""){
                        return defaultResponse;
                    }
                    else {
                        return reply;
                    }
                }
            }
            else {
                String reply = Learnings.getReply(userInput);
                System.out.println("reply: " + reply);
                return Learnings.trainMe(userInput, expectedReply);
            }
        });
    }
}
