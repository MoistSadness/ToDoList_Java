import java.awt.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        System.out.println("");
        System.out.println("Welcome to the To Do list:");

        Scanner userInput = new Scanner(System.in);     // Create a scanner object for user input

        boolean isRunning = true;
        while(isRunning) {
            System.out.println("");
            System.out.println("----------------------------------");
            System.out.println("Please choose one of the following:");
            System.out.println("\t1. Create new todo");
            System.out.println("\t2. Remove todo");
            System.out.println("\t3. Update todo");
            System.out.println("\t4. Display todos");
            System.out.println("\t5. Exit");

            String choice = userInput.nextLine();

            switch(choice){
                case "1":
                    System.out.println("1");
                    break;
                case "2":
                    System.out.println("2");
                    break;
                case "3":
                    System.out.println("3");
                    break;
                case "4":
                    System.out.println("4");
                    break;
                case "5":
                    System.out.println("Exiting program");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }
        }

    }
}
