import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class Inputs {

    public String[] greetings = {"Hi", "Hello", "Good morning", "Good afternoon", "Good evening", "Good night", "Good bye", "Thank you", "Thanks"};
    public String[] questions = {"What packages", "What are the packages", "Package", "Packages", "Package details", "pt1"};

    public String removeSpaces(String[] inputs){
        return String.join("", inputs).toLowerCase().replaceAll("\\s", "");
    }
}
