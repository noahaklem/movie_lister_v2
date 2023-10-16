import java.util.Scanner;
import java.util.Arrays;

public class CLI {
    public void greet() {
        System.out.println("Hello! Welcome to Movie Lister.\n");
        get_input();
    }

    public void get_input() {
        System.out.print("Would you like to view trending movies? Type: 'yes', 'y' or 'sure'");
        Scanner scanner = new Scanner(System.in);
        String user_input = scanner.nextLine();
        scanner.close();
        String converted_input = convert_input(user_input);
        if(valid_input(converted_input)) {
            try {
                API.fetchMovieData();
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        } else {
            get_input();
        }
    }

    public String convert_input(String user_input) {
        user_input = user_input.strip();
        return user_input.toLowerCase().toString();
    }

    public Boolean valid_input(String user_input) {
        String[] answers = {"yes", "y", "sure"};
        return Arrays.asList(answers).contains(user_input);
    }
}
