import java.util.Arrays;
import java.util.Scanner;

public class CLI {

    public void greet() {
        System.out.print("Welcome to Movie Lister\n");
        get_input();
    }

    public void get_input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to see trending movies? Type: 'yes', 'no', or 'sure'");
        String user_input;
        user_input = input.nextLine();
        user_input = convert_input(user_input);
        if (is_valid(user_input)) {
            try {
               API.fetchMovieData(); 
            } catch (Exception e) {
                System.err.println("Error " + e.getMessage());
            }
            
        } else {
            get_input();
        }
        input.close();
    }

    public String convert_input(String user_input){
        user_input = user_input.strip().toLowerCase();
        return user_input;
    }

    public boolean is_valid(String user_input) {
        String[] answers = {"yes", "y", "sure"};
        return Arrays.asList(answers).contains(user_input);
    }



    public static void main(String[] args){
        CLI cli = new CLI();
        cli.greet();

    }
}

