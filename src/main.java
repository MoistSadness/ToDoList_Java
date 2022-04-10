import java.awt.*;
import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class main {

    static void readFromFile(){}
    static void writeToFile(){}

    static String userInputString(){
        Scanner input = new Scanner(System.in);     // Create a scanner object for user input
        return input.nextLine();
    }

    static int userInputInt(){
        int userInput;
        while(true) {
            try {
                Scanner input = new Scanner(System.in);
                userInput = input.nextInt();
                break;
            }
            catch(InputMismatchException | NumberFormatException ex ) {
                System.out.println("Invalid Number, Please try again");
            }
        }
        return userInput;
    }

    static void sortByDaysLeft(){}


    /*
    * Creates a Todo object and populates it with data
    * Returns the Todo object
    */
    static Todo createTodo(){
        //System.out.println("1");
        System.out.println("Creating a new todo");

        Todo newTodo = new Todo();      // Creates new Todo object

        System.out.println("Please enter a title");
        newTodo.title = userInputString();

        System.out.println("Please enter a description");
        newTodo.description = userInputString();

        System.out.println("Please enter the completion month");
        newTodo.month = userInputInt();

        System.out.println("Please enter the completion day");
        newTodo.day = userInputInt();

        System.out.println("Please enter the completion year");
        newTodo.year = userInputInt();

        return newTodo;
    }
    static void removeTodo(ArrayList<Todo> TODO){
        System.out.println("2");
        // Ask user what todo they would like to remove
        // Confirm user choice
        // Adjust user choice for index
        // Remove the todo from arraylist
    }
    static void updateTodo(ArrayList<Todo> TODO){
        System.out.println("3");
        // Ask user what todo they would like to update
        // Adjust user choice for index
        // Create new todo
        // Place new todo in the desired index
    }
    /*
     * Prints todos with nice formatting
     */
    static void displayTodos(ArrayList<Todo> TODO){
        //System.out.println("4");
        for (int i = 0; i < TODO.size(); i++){
            System.out.println("###");
            System.out.println("#" + i + "#");
            System.out.println("###");

            // Getting the todo object
            TODO.get(i).print();
        }
    }


    public static void main(String[] args){
        // Read data from file

        // Update all the daysLeft attributes for each todo

        System.out.println("");
        System.out.println("Welcome to the To Do list:");

        // Creating arraylist to store todo objects
        ArrayList<Todo> TODO = new ArrayList<Todo>();

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
            System.out.println("");
            String choice = userInput.nextLine();

            switch(choice){
                case "1":
                    Todo newTodo = createTodo();    // Create a todo
                    //newTodo.printTodo();
                    TODO.add(newTodo);              // Add todo to the arraylist
                    break;
                case "2":
                    removeTodo(TODO);
                    break;
                case "3":
                    updateTodo(TODO);
                    break;
                case "4":
                    displayTodos(TODO);
                    break;
                case "5":
                    System.out.println("Exiting program");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Please enter a valid choice");
            }
            // Sort the todos by the number of days left
            // Save data to file
        }

    }
}
