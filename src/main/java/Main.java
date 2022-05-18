import spark.ModelAndView;
import spark.Spark;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.text.MessageFormat;
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
            return MessageFormat.format("You said {0}", request.queryParams("question"));
        });
    }
}
