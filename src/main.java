import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

//      Libraries for file IO


public class main {
    static void readFromFile(ArrayList<Todo> TODO){
        try{
            // Create stream input objects
            FileInputStream f = new FileInputStream("data.txt");
            ObjectInputStream o = new ObjectInputStream(f);
            TODO = (ArrayList<Todo>) o.readObject();

            o.close();
            f.close();

        }catch (Exception FileNotFoundException){
            System.out.println("File doesn't exist'");
        }

    }

    static void writeToFile(ArrayList<Todo> TODO){
        try {
            // Creating output stream objects
            FileOutputStream f = new FileOutputStream(new File("data.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Iterate through the arraylist and write every object to file
            for(int i = 0; i < TODO.size(); i++){
                o.writeObject(TODO.get(i));
            }

            // Close stream output object
            o.close();
            f.close();
        }catch(Exception FileNotFoundException){
            System.out.println("File doesn't exist'");
            try {
                File file = new File("data.txt");
                file.createNewFile();
                System.out.println("Empty File Created:- " + file.length());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

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


    /***************************************
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

    /***************************************
     * Deletes todo at a specified location
     */
    static void removeTodo(ArrayList<Todo> TODO){
        //System.out.println("2");
        // Ask user what todo they would like to remove
        int choice = userInputInt();
        int index = choice - 1;

        // Confirm user choice
        Scanner input = new Scanner(System.in);
        System.out.println("Removing todo " + index);
        System.out.println("Please confirm y or n");
        String confirmation = input.nextLine();
        if (confirmation.equals("y") || confirmation.equals("Y")){
            TODO.remove(index);
            System.out.println("Todo " + index + " has been removed");
        }else{
            System.out.println("Cancelling Todo removal");
        }

        // Adjust user choice for index
        // Remove the todo from arraylist
    }

    /***************************************
     * Updates todo at a desired location
     */
    static void updateTodo(ArrayList<Todo> TODO){
        System.out.println("3");
        // Ask user what todo they would like to update
        int choice = userInputInt();
        int index = choice - 1;

        // Create new todo
        Todo newTodo = createTodo();

        // Place new todo in the desired index
        try {
            TODO.set(index, newTodo);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Unable to update to the Todo ");
        }
    }

    /***************************************
     * Prints todos with nice formatting
     */
    static void displayTodos(ArrayList<Todo> TODO){
        //System.out.println("4");
        for (int i = 0; i < TODO.size(); i++){
            System.out.println("#####");
            System.out.println("# " + i + " #");
            System.out.println("#####");

            // Getting the todo object
            TODO.get(i).print();
        }
    }



    /*********************************************
    /*********************************************
    ******                                  ******
    ******          MAIN FUNCTION           ******
    ******                                  ******
    **********************************************
    *********************************************/
    public static void main(String[] args){
        // Creating arraylist to store todo objects
        ArrayList<Todo> TODO = new ArrayList<Todo>();

        // Read data from file
        readFromFile(TODO);

        // Update all the daysLeft attributes for each todo

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
            writeToFile(TODO);
        }

    }
}
